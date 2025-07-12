# k8s-platform-tools

本项目用于在 Kubernetes 集群中安装以下开源工具，搭建起一套集合了认证鉴权、监控告警、日志收集、消息队列、证书机密管理、七层代理、资源控制等功能的kubernetes应用部署平台。

## 工具列表及作用

| 工具名称                       | 作用简介                                                                 | 工具文档                                             |
| ------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| cert-manager                   | 自动管理 TLS 证书的生命周期。                                            | [cert-manager](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2certmanager.md) |
| kubed                          | 同步 Kubernetes 集群中的配置和资源。                                     | [kubed](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2config-syncer(kubed).md) |
| ingress-nginx                  | 提供基于 NGINX 的 Kubernetes Ingress 控制器。                            | [ingress-nginx](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2ingress-nginx.md) |
| external-dns                   | 自动管理 Kubernetes 集群的 DNS 记录。                                    | [external-dns](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2external-dns.md) |
| external-secrets               | 将外部密钥管理系统的密钥同步到 Kubernetes Secret 中。                     | [external-secrets](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2external-secrets.md) |
| oauth2-proxy                   | 提供基于 OAuth2 的身份验证代理。                                         | [oauth2-proxy](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2oauth2proxy.md) |
| trivy-operator                 | 在 Kubernetes 中进行容器镜像和资源的安全扫描。                           | [trivy-operator](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2trivy-operator.md) |
| kyverno                        | Kubernetes 原生的策略管理工具。                                          | [kyverno](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2kyverno%E5%92%8Cpolicy-reporter.md#kyverno) |
| policy-reporter                | 收集和报告 Kubernetes 策略的执行结果。                                   | [policy-reporter](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2kyverno%E5%92%8Cpolicy-reporter.md#kyverno-policy-reporter) |
| capsule                        | 多租户 Kubernetes 集群管理工具。                                         | [capsule](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2capsule.md) |
| reloader                       | 自动重新加载配置更改的 Kubernetes 部署。                                 | [reloader](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2reloader.md) |
| nfs-subdir-external-provisioner | 提供基于 NFS 的动态存储卷管理。                                          | [nfs-subdir-external-provisioner](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2nfs-subdir-external-provisioner.md) |
| harbor                         | 云原生的容器镜像仓库。                                                   | [harbor](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2harbor.md) |
| grafana-agent                  | 用于监控和日志收集的轻量级代理。                                         | [grafana-agent](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2Loki-promtail-tempo-grafanaAgent%E5%85%A8%E5%AE%B6%E6%A1%B6.md#helm%E9%83%A8%E7%BD%B2grafana-agent) |
| kube-prometheus-stack          | 提供 Kubernetes 集群的全面监控和告警解决方案。                           | [kube-prometheus-stack](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署prometheus-stack全家桶.md) |
| loki                           | 日志聚合系统。                                                          | [loki](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署Loki-promtail-tempo-grafanaAgent全家桶.md#helm部署loki-promtail-tempo全家桶) |
| promtail                       | 日志收集工具，通常与 Loki 配合使用。                                     | [promtail](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署Loki-promtail-tempo-grafanaAgent全家桶.md#promtail) |
| tempo                          | 分布式追踪系统。                                                        | [tempo](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署Loki-promtail-tempo-grafanaAgent全家桶.md#tempo) |
| strimzi-kafka-operator         | 用于管理 Apache Kafka 的 Kubernetes Operator。                           | [strimzi-kafka-operator](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署kafka.md#部署srtimzi-kafka-operator) |
| kafka-ui                       | Kafka 的 Web 管理界面。                                                 | [kafka-ui](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署kafka.md#部署kafka-ui) |
| vpa                            | Kubernetes 的垂直 Pod 自动扩展工具。                                     | [vpa](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署vpa.md) |
| goldilocks                     | 提供资源请求和限制的优化建议。                                           | [goldilocks](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署goldilock.md) |
| pact-broker                    | 用于管理 Pact 合约的服务。                                              | [pact-broker](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署pact-broker.md) |
| jaeger                         | 分布式追踪系统，用于监控和调试微服务架构。                               | [jaeger](https://github.com/hangx969/learning-notes/blob/af933226a50422c14a3e0eedda421d0e2e3271ad/Docker-Kubernetes/helm/helm部署jaeger.md) |
| jenkins | 用于创建和管理CICD流水线 | [jenkins](https://github.com/hangx969/learning-notes/blob/a56e46501f66873382a0f64149e5e7678054ef0e/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2jenkins.md) |

## Helm Chart版本

| Repo Name                       | Repo URL                                                     | Chart Name                      | Chart Version | Github/Releases Page                                         | ArtifactHub for Helm Charts                                  |
| ------------------------------- | ------------------------------------------------------------ | ------------------------------- | ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| jetstack                        | https://charts.jetstack.io                                   | cert-manager                    | 1.18.2        | https://github.com/cert-manager/cert-manager/releases/       | https://artifacthub.io/packages/helm/cert-manager/cert-manager |
| appscode                        | https://charts.appscode.com/stable/                          | kubed                           | 0.13.2        | https://github.com/config-syncer/config-syncer?tab=readme-ov-file | https://artifacthub.io/packages/helm/appscode/kubed          |
| ingress-nginx                   | https://kubernetes.github.io/ingress-nginx                   | ingress-nginx                   | 4.13.0        | https://github.com/kubernetes/ingress-nginx/releases         | https://artifacthub.io/packages/helm/ingress-nginx/ingress-nginx |
| external-dns                    | https://kubernetes-sigs.github.io/external-dns               | external-dns                    | 1.17.0        | https://github.com/kubernetes-sigs/external-dns/releases     | https://artifacthub.io/packages/helm/external-dns/external-dns |
| external-secrets                | https://charts.external-secrets.io                           | external-secrets                | 0.18.2        | https://github.com/external-secrets/external-secrets/releases | https://artifacthub.io/packages/helm/external-secrets-operator/external-secrets |
| oauth2-proxy                    | https://oauth2-proxy.github.io/manifests                     | oauth2-proxy                    | 7.12.19       | https://github.com/oauth2-proxy/manifests/releases        | https://artifacthub.io/packages/helm/oauth2-proxy/oauth2-proxy |
| aqua                            | https://aquasecurity.github.io/helm-charts/                  | trivy-operator                  | 0.29.3        | https://github.com/aquasecurity/trivy-operator/releases      | https://artifacthub.io/packages/helm/trivy-operator/trivy-operator |
| kyverno                         | https://kyverno.github.io/kyverno/                           | kyverno                         | 3.4.4         | https://github.com/kyverno/kyverno/releases                  | https://artifacthub.io/packages/helm/kyverno/kyverno/        |
| policy-reporter                 | https://kyverno.github.io/policy-reporter                    | policy-reporter                 | 3.3.1        | https://github.com/kyverno/policy-reporter/releases          | https://artifacthub.io/packages/helm/policy-reporter/policy-reporter |
| projectcapsule                  | https://projectcapsule.github.io/charts                      | capsule                         | 0.10.0         | https://github.com/projectcapsule/capsule/releases           | https://artifacthub.io/packages/helm/projectcapsule/capsule/ |
| stakater                        | https://stakater.github.io/stakater-charts                   | reloader                        | 2.1.5       | https://github.com/stakater/Reloader/releases                | https://artifacthub.io/packages/helm/stakater/reloader       |
| nfs-subdir-external-provisioner | https://kubernetes-sigs.github.io/nfs-subdir-external-provisioner | nfs-subdir-external-provisioner | 4.0.18        | https://github.com/kubernetes-sigs/nfs-subdir-external-provisioner/releases | https://artifacthub.io/packages/helm/nfs-subdir-external-provisioner/nfs-subdir-external-provisioner |
| harbor                          | https://helm.goharbor.io                                     | harbor                          | 1.17.1        | https://github.com/goharbor/harbor-helm/releases             | https://artifacthub.io/packages/helm/harbor/harbor           |
| grafana                         | https://grafana.github.io/helm-charts                        | grafana-agent                   | 0.42.0        | https://github.com/grafana/agent/releases                    | https://artifacthub.io/packages/helm/grafana/grafana-agent   |
| prometheus-community            | https://prometheus-community.github.io/helm-charts           | kube-prometheus-stack           | 75.10.0        | https://github.com/prometheus-community/helm-charts/releases | https://artifacthub.io/packages/helm/prometheus-community/kube-prometheus-stack |
| grafana                         | https://grafana.github.io/helm-charts                        | loki                            | 5.48.0        | https://github.com/grafana/loki/releases                     | https://artifacthub.io/packages/helm/grafana/loki            |
| grafana                         | https://grafana.github.io/helm-charts                        | promtail                        | 6.15.5        | https://github.com/grafana/loki/releases                     | https://artifacthub.io/packages/helm/grafana/promtail        |
| grafana                         | https://grafana.github.io/helm-charts                        | tempo                           | 1.16.0        | https://github.com/grafana/tempo/releases                    | https://artifacthub.io/packages/helm/grafana/tempo           |
| strimzi                         | https://strimzi.io/charts/                                   | strimzi-kafka-operator          | 0.46.1        | https://github.com/strimzi/strimzi-kafka-operator/releases   | https://artifacthub.io/packages/helm/strimzi-kafka-operator/strimzi-kafka-operator |
| kafka-ui                        | https://provectus.github.io/kafka-ui-charts                  | kafka-ui                        | 0.7.6         | https://github.com/provectus/kafka-ui/releases               | https://artifacthub.io/packages/helm/kafka-ui/kafka-ui       |
| fairwinds-stable                | https://charts.fairwinds.com/stable                          | vpa                             | 4.7.1         | https://github.com/kubernetes/autoscaler/releases            | https://artifacthub.io/packages/helm/fairwinds-stable/vpa    |
| fairwinds-stable                | https://charts.fairwinds.com/stable                          | goldilocks                      | 9.0.1         | https://github.com/FairwindsOps/goldilocks/releases          | https://artifacthub.io/packages/helm/fairwinds-stable/goldilocks |
| pact-broker                     | https://pact-foundation.github.io/pact-broker-chart/         | pact-broker                     | 1.1.0         | https://github.com/pact-foundation/pact-broker-chart/releases | N/A                                                          |
| jaegertracing                   | https://jaegertracing.github.io/helm-charts                  | jaeger                          | 3.4.1         | https://github.com/jaegertracing/helm-charts/releases        | https://artifacthub.io/packages/helm/jaegertracing/jaeger    |
| jenkins                         | https://charts.jenkins.io                                    | jenkins                         | 5.8.68        | https://github.com/jenkinsci/helm-charts/tree/main/charts/jenkins | https://artifacthub.io/packages/helm/jenkinsci/jenkins       |

## 部署前提条件

1. 已安装并配置好 Kubernetes 集群（建议kubernetes版本1.24+）。本地VMWare虚拟机上安装教程参考[这里](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/k8s-installation-management/%E5%AE%89%E8%A3%85k8s-1.33-%E5%9F%BA%E4%BA%8Erockylinux.md)。
2. 已安装 [kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/#install-kubectl-on-linux) 和 [helm](https://helm.sh/docs/intro/install/) 工具。
3. 获取kubernetes集群的管理员的kubeconfig文件，并以secret方式保存至github中，方法参考[这里](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/k8s-CICD/%E4%BD%BF%E7%94%A8github%20action%E9%83%A8%E7%BD%B2helmchart.md#%E4%B8%8A%E4%BC%A0%E5%B9%B6%E4%BD%BF%E7%94%A8kubeconfig)。
4. 按照[教程](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/k8s-CICD/%E4%BD%BF%E7%94%A8github%20action%E9%83%A8%E7%BD%B2helmchart.md#%E5%87%86%E5%A4%87%E5%B7%A5%E4%BD%9C)，安装github action runner。

## 部署步骤

### 安装harbor私有镜像仓库

由于许多helm chart的拉取速度较慢，影响pipeline运行速度和成功率，本项目采用私有镜像库harbor来存储helm chart。当安装新应用或者升级应用时，应先使用 [此工作流](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) 下载对应的helm chart并推送到harbor。这样一来，不涉及到新装和升级时，pipeline的每次运行就不需要重复拉取helm chart。

在开始部署此项目前，应先手动安装harbor helm chart：

1. 使用helm部署harbor，values文件参考[这里](https://github.com/hangx969/local-k8s-platform-tools/blob/main/base/external/harbor/values.yaml)

~~~sh
helm repo add harbor https://helm.goharbor.io
helm repo update harbor
helm upgrade -i harbor -n harbor \
            harbor/harbor \
            --version 1.17.0 \
            -f ./base/external/harbor/values.yaml \
~~~

2. harbor部署完成后，使用 [此工作流](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) 下载harbor的helm chart并推送到harbor，以供后续调整配置时使用。

### 配置nfs存储

本项目采用nfs作为PV给其他工具提供存储，按照[nfs-subdir-external-provisioner](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2nfs-subdir-external-provisioner.md)中的指南，在一台机器上安装nfs服务，配置nfs目录并export。nfs-subdir-external-provisioner工具后续会在github action中安装。

### 推送helm chart

安装上述表格中提供的helm chart，使用 [此工作流](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) 逐个下载对应的helm chart并推送到harbor，以供后续github action中安装使用。

## 添加新的工具

1. **获取工具信息**
   确定需要安装的工具的以下信息：
   - Helm 仓库名称
   - Helm 仓库 URL
   - Helm Chart 名称
   - Helm Chart 版本

2. **下载并推送 Helm Chart**
   使用 [此工作流](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) 下载 Helm Chart 并推送到 Harbor。

3. **创建命名空间**
   如果工具需要在新的命名空间中安装，请在 `base/helm-charts/base-ns/` 目录下创建对应的命名空间 YAML 文件。

4. **添加 Helm Chart 配置**
   在项目中添加工具的文件夹和 `values.yaml` 配置文件。

5. **更新工作流**
   - 在构建工作流中添加 `helm diff` 部分。
   - 在部署工作流中添加 `helm upgrade` 部分。

6. **触发安装**
   将代码推送到 GitHub，触发工作流以完成工具的安装。

## 升级工具

1. **获取新版本helm chart信息**
   确定需要升级的工具的以下信息：
   - Helm 仓库名称
   - Helm 仓库 URL
   - Helm Chart 名称
   - Helm Chart 版本

2. **下载并推送 Helm Chart**
   使用 [此工作流](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) 下载新版本 Helm Chart 并推送到 Harbor。

3. 在[github workflow yml](./.github/workflows)中更新工具的版本号

4. 通过Pull Request合并到main branch，触发workflow部署。

## 卸载工具

使用 [此工作流](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-uninstall.yml)，提供 Helm Release 名称和命名空间即可卸载helm chart。
