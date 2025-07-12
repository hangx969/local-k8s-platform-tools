# k8s-platform-tools

This project is used to install the following open-source tools in a Kubernetes cluster, building a Kubernetes application deployment platform with features such as authentication and authorization, monitoring and alerting, log collection, message queue, certificate and secret management, layer 7 proxy, resource control, etc..

## Tool List and Functions

| Tool Name                      | Function Description                                                      | Tool Documentation                                    |
| ------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| cert-manager                   | Automatically manages the lifecycle of TLS certificates.                 | [cert-manager](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2certmanager.md) |
| kubed                          | Synchronizes configurations and resources in Kubernetes clusters.        | [kubed](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2config-syncer(kubed).md) |
| ingress-nginx                  | Provides an NGINX-based Kubernetes Ingress controller.                   | [ingress-nginx](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2ingress-nginx.md) |
| external-dns                   | Automatically manages DNS records for Kubernetes clusters.               | [external-dns](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2external-dns.md) |
| external-secrets               | Synchronizes secrets from external secret management systems to Kubernetes Secrets. | [external-secrets](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2external-secrets.md) |
| oauth2-proxy                   | Provides an OAuth2-based authentication proxy.                           | [oauth2-proxy](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2oauth2proxy.md) |
| trivy-operator                 | Performs security scans for container images and resources in Kubernetes. | [trivy-operator](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2trivy-operator.md) |
| kyverno                        | A Kubernetes-native policy management tool.                              | [kyverno](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2kyverno%E5%92%8Cpolicy-reporter.md#kyverno) |
| policy-reporter                | Collects and reports the execution results of Kubernetes policies.       | [policy-reporter](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2kyverno%E5%92%8Cpolicy-reporter.md#kyverno-policy-reporter) |
| capsule                        | A multi-tenant Kubernetes cluster management tool.                       | [capsule](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2capsule.md) |
| reloader                       | Automatically reloads Kubernetes deployments when configurations change. | [reloader](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2reloader.md) |
| nfs-subdir-external-provisioner | Provides dynamic storage volume management based on NFS.                 | [nfs-subdir-external-provisioner](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2nfs-subdir-external-provisioner.md) |
| harbor                         | A cloud-native container image registry.                                 | [harbor](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2harbor.md) |
| grafana-agent                  | A lightweight agent for monitoring and log collection.                   | [grafana-agent](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2Loki-promtail-tempo-grafanaAgent%E5%85%A8%E5%AE%B6%E6%A1%B6.md#helm%E9%83%A8%E7%BD%B2grafana-agent) |
| kube-prometheus-stack          | Provides a comprehensive monitoring and alerting solution for Kubernetes clusters. | [kube-prometheus-stack](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署prometheus-stack全家桶.md) |
| loki                           | A log aggregation system.                                                | [loki](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署Loki-promtail-tempo-grafanaAgent全家桶.md#helm部署loki-promtail-tempo全家桶) |
| promtail                       | A log collection tool, often used with Loki.                             | [promtail](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署Loki-promtail-tempo-grafanaAgent全家桶.md#promtail) |
| tempo                          | A distributed tracing system.                                            | [tempo](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署Loki-promtail-tempo-grafanaAgent全家桶.md#tempo) |
| strimzi-kafka-operator         | A Kubernetes Operator for managing Apache Kafka.                         | [strimzi-kafka-operator](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署kafka.md#部署srtimzi-kafka-operator) |
| kafka-ui                       | A web management interface for Kafka.                                    | [kafka-ui](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署kafka.md#部署kafka-ui) |
| vpa                            | A vertical Pod autoscaler for Kubernetes.                                | [vpa](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署vpa.md) |
| goldilocks                     | Provides optimization suggestions for resource requests and limits.       | [goldilocks](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署goldilock.md) |
| pact-broker                    | A service for managing Pact contracts.                                   | [pact-broker](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm部署pact-broker.md) |
| jaeger                         | A distributed tracing system for monitoring and debugging microservices architectures. | [jaeger](https://github.com/hangx969/learning-notes/blob/af933226a50422c14a3e0eedda421d0e2e3271ad/Docker-Kubernetes/helm/helm部署jaeger.md) |
| jenkins | A CICD pipeline manager | [jenkins](https://github.com/hangx969/learning-notes/blob/a56e46501f66873382a0f64149e5e7678054ef0e/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2jenkins.md) |

## Helm Chart Versions

| Repo Name                       | Repo URL                                                     | Chart Name                      | Chart Version | Github/Releases Page                                         | ArtifactHub for Helm Charts                                  |
| ------------------------------- | ------------------------------------------------------------ | ------------------------------- | ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| jetstack                        | https://charts.jetstack.io                                   | cert-manager                    | 1.18.2        | https://github.com/cert-manager/cert-manager/releases/       | https://artifacthub.io/packages/helm/cert-manager/cert-manager |
| appscode                        | https://charts.appscode.com/stable/                          | kubed                           | 0.13.2        | https://github.com/config-syncer/config-syncer?tab=readme-ov-file | https://artifacthub.io/packages/helm/appscode/kubed          |
| ingress-nginx                   | https://kubernetes.github.io/ingress-nginx                   | ingress-nginx                   | 4.13.0        | https://github.com/kubernetes/ingress-nginx/releases         | https://artifacthub.io/packages/helm/ingress-nginx/ingress-nginx |
| external-dns                    | https://kubernetes-sigs.github.io/external-dns               | external-dns                    | 1.15.2        | https://github.com/kubernetes-sigs/external-dns/releases     | https://artifacthub.io/packages/helm/external-dns/external-dns |
| external-secrets                | https://charts.external-secrets.io                           | external-secrets                | 0.17.0        | https://github.com/external-secrets/external-secrets/releases | https://artifacthub.io/packages/helm/external-secrets-operator/external-secrets |
| oauth2-proxy                    | https://oauth2-proxy.github.io/manifests                     | oauth2-proxy                    | 7.12.13       | https://github.com/oauth2-proxy/oauth2-proxy/releases        | https://artifacthub.io/packages/helm/oauth2-proxy/oauth2-proxy |
| aqua                            | https://aquasecurity.github.io/helm-charts/                  | trivy-operator                  | 0.28.1        | https://github.com/aquasecurity/trivy-operator/releases      | https://artifacthub.io/packages/helm/trivy-operator/trivy-operator |
| kyverno                         | https://kyverno.github.io/kyverno/                           | kyverno                         | 3.2.7         | https://github.com/kyverno/kyverno/releases                  | https://artifacthub.io/packages/helm/kyverno/kyverno/        |
| policy-reporter                 | https://kyverno.github.io/policy-reporter                    | policy-reporter                 | 2.24.2        | https://github.com/kyverno/policy-reporter/releases          | https://artifacthub.io/packages/helm/policy-reporter/policy-reporter |
| projectcapsule                  | https://projectcapsule.github.io/charts                      | capsule                         | 0.7.4         | https://github.com/projectcapsule/capsule/releases           | https://artifacthub.io/packages/helm/projectcapsule/capsule/ |
| stakater                        | https://stakater.github.io/stakater-charts                   | reloader                        | 1.0.115       | https://github.com/stakater/Reloader/releases                | https://artifacthub.io/packages/helm/stakater/reloader       |
| nfs-subdir-external-provisioner | https://kubernetes-sigs.github.io/nfs-subdir-external-provisioner | nfs-subdir-external-provisioner | 4.0.18        | https://github.com/kubernetes-sigs/nfs-subdir-external-provisioner/releases | https://artifacthub.io/packages/helm/nfs-subdir-external-provisioner/nfs-subdir-external-provisioner |
| harbor                          | https://helm.goharbor.io                                     | harbor                          | 1.17.1        | https://github.com/goharbor/harbor-helm/releases             | https://artifacthub.io/packages/helm/harbor/harbor           |
| grafana                         | https://grafana.github.io/helm-charts                        | grafana-agent                   | 0.45.0        | https://github.com/grafana/agent/releases                    | https://artifacthub.io/packages/helm/grafana/grafana-agent   |
| prometheus-community            | https://prometheus-community.github.io/helm-charts           | kube-prometheus-stack           | 59.1.0        | https://github.com/prometheus-community/helm-charts/releases | https://artifacthub.io/packages/helm/prometheus-community/kube-prometheus-stack |
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

## Prerequisites

1. A Kubernetes cluster is installed and configured (recommended Kubernetes version 1.24+). For installation tutorial on local VMWare virtual machine, refer to [here](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/k8s-installation-management/%E5%AE%89%E8%A3%85k8s-1.33-%E5%9F%BA%E4%BA%8Erockylinux.md).
2. [kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/#install-kubectl-on-linux) and [helm](https://helm.sh/docs/intro/install/) tools are installed.
3. The kubeconfig file of the Kubernetes cluster administrator is obtained and saved as a secret in GitHub, refer to [here](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/k8s-CICD/%E4%BD%BF%E7%94%A8github%20action%E9%83%A8%E7%BD%B2helmchart.md#%E4%B8%8A%E4%BC%A0%E5%B9%B6%E4%BD%BF%E7%94%A8kubeconfig) for method.
4. Install GitHub action runner according to the [tutorial](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/k8s-CICD/%E4%BD%BF%E7%94%A8github%20action%E9%83%A8%E7%BD%B2helmchart.md#%E5%87%86%E5%A4%87%E5%B7%A5%E4%BD%9C).

## Deployment Steps

### Install Harbor Private Image Registry

Due to the slow pull speed of many helm charts, which affects the pipeline running speed and success rate, this project uses the private image registry Harbor to store helm charts. When installing or upgrading applications, you should first use [this workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) to download the corresponding helm chart and push it to Harbor. In this way, except for new installations and upgrades, the pipeline does not need to pull the helm chart repeatedly in each run.

Before starting this item, manually install the Harbor helm chart:

1. Deploy Harbor using helm, refer to the values file [here](https://github.com/hangx969/local-k8s-platform-tools/blob/main/base/external/harbor/values.yaml)

~~~sh
helm repo add harbor https://helm.goharbor.io
helm repo update harbor
helm upgrade -i harbor -n harbor \
            harbor/harbor \
            --version 1.17.0 \
            -f ./base/external/harbor/values.yaml \
~~~

2. After Harbor is deployed, use [this workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) to download the helm chart of Harbor and push it to Harbor for later configuration adjustments.

### Configure NFS Storage

This project uses NFS as PV to provide storage for other tools. Install the NFS service on one machine and configure the NFS directory and export it according to the guide in [nfs-subdir-external-provisioner](https://github.com/hangx969/learning-notes/blob/main/Docker-Kubernetes/helm/helm%E9%83%A8%E7%BD%B2nfs-subdir-external-provisioner.md). The nfs-subdir-external-provisioner tool will be installed later in the GitHub action.

### Push Helm Charts

Install the helm charts provided in the above table, use [this workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) to download the corresponding helm charts one by one and push them to Harbor for use in subsequent GitHub actions.

## Add New Tools

1. **Get Tool Information**
   Determine the following information for the tool you need to install:
   - Helm repository name
   - Helm repository URL
   - Helm chart name
   - Helm chart version

2. **Download and Push Helm Chart**
   Use [this workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) to download the Helm chart and push it to Harbor.

3. **Create Namespace**
   If the tool needs to be installed in a new namespace, create the corresponding namespace YAML file in the `base/helm-charts/base-ns/` directory.

4. **Add Helm Chart Configuration**
   Add the tool's folder and `values.yaml` configuration file to the project.

5. **Update Workflow**
   - Add the `helm diff` section in the build workflow.
   - Add the `helm upgrade` section in the deployment workflow.

6. **Trigger Installation**
   Push the code to GitHub to trigger the workflow to complete the tool installation.

## Upgrade Tools

1. **Get helm chart info of newer version**:
   - Helm repository name
   - Helm repository URL
   - Helm chart name
   - Helm chart version
2. **Download and Push Helm Chart**
   Use [this workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml) to download the newer version Helm chart and push it to Harbor.
3. Update the version in [github workflow yml](./.github/workflows)
4. Create Pull Request to merge to main branch, which will trigger the workflow to deploy.

## Uninstall Tools

Use [this workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-uninstall.yml), providing the Helm release name and namespace to uninstall the helm chart.