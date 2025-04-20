# k8s-platform-tools

This repository installs below helm charts of cloud platform tools in a kubernetes cluster.

## Helm Charts List

| Repo Name                       | Repo URL                                                     | Chart Name                      | Chart Version | Github/Releases Page | ArtifactHub for Helm Charts |
| ------------------------------- | ------------------------------------------------------------ | ------------------------------- | ------------- | ------------- | ------------- |
| jetstack                        | https://charts.jetstack.io                                   | cert-manager                    | 1.17.1        | https://github.com/cert-manager/cert-manager/releases/ | https://artifacthub.io/packages/helm/cert-manager/cert-manager |
| appscode                        | https://charts.appscode.com/stable/                          | kubed                           | 0.13.2        | https://github.com/config-syncer/config-syncer?tab=readme-ov-file | https://artifacthub.io/packages/helm/appscode/kubed |
| ingress-nginx                   | https://kubernetes.github.io/ingress-nginx                   | ingress-nginx                   | 4.12.1        | https://github.com/kubernetes/ingress-nginx/releases | https://artifacthub.io/packages/helm/ingress-nginx/ingress-nginx |
| external-dns                    | https://kubernetes-sigs.github.io/external-dns               | external-dns                    | 1.15.2        | https://github.com/kubernetes-sigs/external-dns/releases | https://artifacthub.io/packages/helm/external-dns/external-dns |
| external-secrets                | https://charts.external-secrets.io                           | external-secrets                | 0.14.4        | https://github.com/external-secrets/external-secrets/releases | https://artifacthub.io/packages/helm/external-secrets-operator/external-secrets |
| oauth2-proxy                    | https://oauth2-proxy.github.io/manifests                     | oauth2-proxy                    | 7.12.6        | https://github.com/oauth2-proxy/oauth2-proxy/releases | https://artifacthub.io/packages/helm/oauth2-proxy/oauth2-proxy |
| aqua                            | https://aquasecurity.github.io/helm-charts/                  | trivy-operator                  | 0.27.0        | https://github.com/aquasecurity/trivy-operator/releases | https://artifacthub.io/packages/helm/trivy-operator/trivy-operator |
| kyverno                         | https://kyverno.github.io/kyverno/                           | kyverno                         | 3.2.7         | https://github.com/kyverno/kyverno/releases | https://artifacthub.io/packages/helm/kyverno/kyverno/ |
| policy-reporter                 | https://kyverno.github.io/policy-reporter                    | policy-reporter                 | 2.24.2        | https://github.com/kyverno/policy-reporter/releases | https://artifacthub.io/packages/helm/policy-reporter/policy-reporter |
| projectcapsule                  | https://projectcapsule.github.io/charts                      | capsule                         | 0.7.1         | https://github.com/projectcapsule/capsule/releases | https://artifacthub.io/packages/helm/projectcapsule/capsule/ |
| stakater                        | https://stakater.github.io/stakater-charts                   | reloader                        | 1.0.115       | https://github.com/stakater/Reloader/releases | https://artifacthub.io/packages/helm/stakater/reloader |
| nfs-subdir-external-provisioner | https://kubernetes-sigs.github.io/nfs-subdir-external-provisioner | nfs-subdir-external-provisioner | 4.0.18        | https://github.com/kubernetes-sigs/nfs-subdir-external-provisioner/releases | https://artifacthub.io/packages/helm/nfs-subdir-external-provisioner/nfs-subdir-external-provisioner |
| harbor                          | https://helm.goharbor.io                                     | harbor                          | 1.17.0        | https://github.com/goharbor/harbor-helm/releases | https://artifacthub.io/packages/helm/harbor/harbor |
| grafana                         | https://grafana.github.io/helm-charts                        | grafana-agent                   | 0.42.0        | https://github.com/grafana/agent/releases | https://artifacthub.io/packages/helm/grafana/grafana-agent |
| prometheus-community            | https://prometheus-community.github.io/helm-charts           | kube-prometheus-stack           | 59.1.0        | https://github.com/prometheus-community/helm-charts/releases | https://artifacthub.io/packages/helm/prometheus-community/kube-prometheus-stack |
| grafana                         | https://grafana.github.io/helm-charts                        | loki                            | 5.48.0        | https://github.com/grafana/loki/releases | https://artifacthub.io/packages/helm/grafana/loki |
| grafana                         | https://grafana.github.io/helm-charts                        | promtail                        | 6.15.5        | https://github.com/grafana/loki/releases | https://artifacthub.io/packages/helm/grafana/promtail |
| grafana                         | https://grafana.github.io/helm-charts                        | tempo                           | 1.16.0         | https://github.com/grafana/tempo/releases | https://artifacthub.io/packages/helm/grafana/tempo |
| strimzi                         | https://strimzi.io/charts/                                   | strimzi-kafka-operator          | 0.42.0        | https://github.com/strimzi/strimzi-kafka-operator/releases | https://artifacthub.io/packages/helm/strimzi-kafka-operator/strimzi-kafka-operator |
| kafka-ui                        | https://provectus.github.io/kafka-ui-charts                  | kafka-ui                        | 0.7.6         | https://github.com/provectus/kafka-ui/releases | https://artifacthub.io/packages/helm/kafka-ui/kafka-ui |
| fairwinds-stable                | https://charts.fairwinds.com/stable                          | vpa                             | 4.7.1         | https://github.com/kubernetes/autoscaler/releases | https://artifacthub.io/packages/helm/fairwinds-stable/vpa |
| fairwinds-stable                | https://charts.fairwinds.com/stable                          | goldilocks                      | 9.0.1         | https://github.com/FairwindsOps/goldilocks/releases | https://artifacthub.io/packages/helm/fairwinds-stable/goldilocks |

## How to install a new tool via helm chart

1. Get below infomation:
   1. helm repo name
   2. helm repo URL
   3. helm chart name
   4. helm chart version
2. Download the helm chart and push to harbor with above infomation using [This workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml).
3. If this helm chart will be installed in a new namespace, create namespace YAML manifest under base/helm-charts/base-ns/.
4. Add the folder and values.yaml file of the helm chart.
5. Add `helm diff` part to build workflow.
6. Add `helm upgrade` part to deploy workflow.
7. Push code to github to trigger the workflow to install it.

## How to uninstall a helm release

Use [This workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-uninstall.yml), provide release name and namespace to uninstall it.
