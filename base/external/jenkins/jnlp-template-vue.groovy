pipeline {
  agent {
    kubernetes {
      // 这里改成Jenkins里面配置的Cloud Name
      cloud 'kubernetes'
      slaveConnectTimeout 1200
      // 将workspace改成用PVC，用于持久化工作目录，claimName为创建的PVC名称
      workspaceVolume persistentVolumeClaimWorkspaceVolume(claimName: "pipeline-workspace-pvc", readOnly: false)
      yaml '''
apiVersion: v1
kind: Pod
spec:
  restartPolicy: "Never"
  # 可选，用打了标签的节点作为slave
  nodeSelector:
    build: "true"
  volumes:
  # 保存docker认证信息
  - name: docker-registry-config
    configMap:
      name: docker-registry-config
  - name: "localtime"
    hostPath:
      path: "/usr/share/zoneinfo/Asia/Shanghai"
  # 缓存PVC
  - name: pipeline-build-cache
    persistentVolumeClaim:
      claimName: pipeline-build-cache-pvc
      readonly: false
  containers:
  # jnlp容器,和Jenkins主节点通信
  - name: jnlp
    image: 'registry.cn-beijing.aliyuncs.com/dotbalo/jnlp-agent-docker:latest'
    imagePullPolicy: IfNotPresent
    args: [\'$(JENKINS_SECRET)\', \'$(JENKINS_NAME)\']
    volumeMounts:
    - name: "localtime"
      mountPath: "/etc/localtime"
      readOnly: false
  # build容器,包含执行构建的命令。stage名称和这个容器名称一致。
  - name: "build"
    image: "registry.cn-beijing.aliyuncs.com/dotbalo/node:lts"
    imagePullPolicy: "IfNotPresent"
    tty: true
    command:
    - "cat"
    env:
    - name: "LANGUAGE"
      value: "en_US:en"
    - name: "LC_ALL"
      value: "en_US.UTF-8"
    - name: "LANG"
      value: "en_US.UTF-8"
    volumeMounts:
    - mountPath: "/etc/localtime"
      name: "localtime"
    # Java编译会把依赖插件装到~/.m2目录下，所以把该目录缓存到PVC。其他语言用类似方式。
    - mountPath: "/root/.m2/"
      name: "pipeline-build-cache"
      readOnly: false
  # 做镜像的容器，可以用docker in docker的方式，或者用kaniko
  - name: "kaniko"
    image: "registry.cn-beijing.aliyuncs.com/dotbalo/kaniko-executor:debug"
    imagePullPolicy: "IfNotPresent"
    tty: true
    command:
    - "sleep"
    args:
    - "99d"
    env:
    - name: "LANGUAGE"
      value: "en_US:en"
    - name: "LC_ALL"
      value: "en_US.UTF-8"
    - name: "LANG"
      value: "en_US.UTF-8"
    volumeMounts:
    - name: "localtime"
      mountPath: "/etc/localtime"
      readOnly: false
    # 挂载docker配置文件，用于Kaniko连接到镜像仓库。Kaniko是自动登录镜像仓库，不用写login之类的命令
    - name: "docker-registry-config"
      mountPath: "/kaniko/.docker"
  # 发版容器，可以用kubectl或者helm的镜像
  - name: "kubectl"
    image: "registry.cn-beijing.aliyuncs.com/dotbalo/kubectl:latest"
    imagePullPolicy: "IfNotPresent"
    tty: true
    command:
    - "cat"
    env:
    - name: "LANGUAGE"
      value: "en_US:en"
    - name: "LC_ALL"
      value: "en_US.UTF-8"
    - name: "LANG"
      value: "en_US.UTF-8"
    volumeMounts:
    - name: "localtime"
      mountPath: "/etc/localtime"
      readOnly: false
'''
    }
  }
  environment {
    HARBOR_ADDRESS = "192.168.40.180:32002" // Harbor地址
    REGISTRY_DIR = "platform-tools-local" // Harbor Project名称
    IMAGE_NAME = "vue-project" // 构建的镜像名称
    NAMESPACE = "demo" // 构建的应用在k8s中的名称空间
    COMMIT_ID = ""
    TAG = "" // 镜像tag，后面用BUILD_TAG+COMMIT_ID的方式生成
    GIT_URL = "git@192.168.40.183:local-k8s-platform-tools/vue-project.git" // gitlab项目的ssh地址
  }
  parameters {
    // 依赖git parameter插件。该字段会在Jenkins页面上显示一个下拉列表，列出所有的分支供选择
    gitParameter(branch: '', branchFilter: 'origin/(.*)', defaultValue: '', description: 'Branch for build and deploy', name: 'BRANCH', quickFilterEnabled: false, selectedValue: 'NONE', sortMode: 'NONE',
tagFilter: '*', type: 'PT_BRANCH')
  }
  stages {
    stage('Pulling Code') {
      parallel {
      // 两个并行stage，因为要考虑到两种触发方式去选择
      // 一种是直接在Jenkins上点构建按钮，这时BRANCH参数有值
      // 另一种是通过gitlab的webhook触发，这时BRANCH参数为空，gitlabBranch环境变量有值
        stage('Pulling Code by Jenkins') {
          when {
            // 假如流水线是手动触发，则env.gitlabBranch为空。执行该stage
            expression {
              env.gitlabBranch == null
            }
          }
          steps {
            // jenkins上保存的ssh私钥credential的名字gitlab-key
            git(changelog: true, poll: true, url: "${GIT_URL}", branch: "${BRANCH}", credentialsId: 'gitlab-key')
            script {
              COMMIT_ID = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
              TAG = BUILD_TAG + '-' + COMMIT_ID
              println "Current branch is ${BRANCH}, Commit ID is ${COMMIT_ID}, Image TAG is ${TAG}"
            }
          }
        }
        stage('Pulling Code by trigger') {
          // 假如流水线是被gitlab的webhook触发，env.gitlabBranch有值。执行该stage
          when {
            expression {
              env.gitlabBranch != null
            }
          }
          steps {
            // jenkins上保存的ssh私钥credential的名字gitlab-key
            git(url: "${GIT_URL}", branch: env.gitlabBranch, changelog: true, poll: true, credentialsId: 'gitlab-key')
            script {
              COMMIT_ID = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
              TAG = BUILD_TAG + '-' + COMMIT_ID
              println "Current branch is ${env.gitlabBranch}, Commit ID is ${COMMIT_ID}, Image TAG is ${TAG}"
            }
          }
        }
      }
    }
    stage('Building') {
      steps {
        // 使用pod模板中定义的build container
        container(name: 'build') {
          // 编译命令，需要根据实际情况修改
            sh """
              npm install --registry=https://registry.npmmirror.com/
              npm run build
            """
        }
      }
    }
    stage('Build for creating image') {
      steps {
        container(name: 'kaniko') {
          // 用kaniko构建镜像并push到harbor
          sh """
            executor -d ${HARBOR_ADDRESS}/${REGISTRY_DIR}/${IMAGE_NAME}:${TAG} -c . --insecure --skip-tls-verify
          """
        }
      }
    }
    stage('Deploying to K8s') {
      environment {
        // 发布到哪个集群，就用保存好的kubeconfig的credential
        MY_KUBECONFIG = credentials('KUBECONFIG_LOCAL')
      }
      steps {
        container(name: 'kubectl'){
            sh """
            kubectl --kubeconfig $MY_KUBECONFIG set image deploy -l app=${IMAGE_NAME} ${IMAGE_NAME}=${HARBOR_ADDRESS}/${REGISTRY_DIR}/${IMAGE_NAME}:${TAG} -n $NAMESPACE
            """
        }
      }
    }
  }
}