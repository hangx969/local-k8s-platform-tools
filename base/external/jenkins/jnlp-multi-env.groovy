pipeline {
    agent {
        kubernetes {
        cloud 'kubernetes'
        slaveConnectTimeout 1200
        yaml '''
apiVersion: v1
kind: Pod
spec:
  restartPolicy: "Never"
  containers:
  # 只需要配置jnlp和kubectl镜像即可
  - name: jnlp
    image: 'registry.cn-beijing.aliyuncs.com/dotbalo/jnlp-agent-docker:latest'
    imagePullPolicy: IfNotPresent
    args: [\'$(JENKINS_SECRET)\', \'$(JENKINS_NAME)\']
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
'''
        }
    }
    environment {
        HARBOR_ADDRESS = "192.168.40.180:32002"
        NAMESPACE = "demo"
        IMAGE_NAME = "go-project"
        TAG = ""
    }
    stages {
        stage('Deploy') {
            environment {
                MY_KUBECONFIG = credentials('KUBECONFIG_LOCAL')
            }
            steps {
                container(name: 'kubectl'){
                    sh """
                        echo ${IMAGE_TAG} # 该变量即为前台选择的镜像
                        kubectl --kubeconfig=${MY_KUBECONFIG} -n ${NAMESPACE} set image deployment -l app=${IMAGE_NAME} ${IMAGE_NAME}=${HARBOR_ADDRESS}/${IMAGE_TAG}
                        kubectl --kubeconfig=${MY_KUBECONFIG} get po  -l app=${IMAGE_NAME} -n ${NAMESPACE} -w
                    """
                }
            }
        }
    }
}