# k8s-platform-tools

## Helm Chart List

| Repo Name                       | Repo URL                                                     | Chart Name                      | Chart Version |
| ------------------------------- | ------------------------------------------------------------ | ------------------------------- | ------------- |
| jetstack                        | https://charts.jetstack.io                                   | cert-manager                    | 1.16.1        |
| appscode                        | https://charts.appscode.com/stable/                          | kubed                           | 0.13.2        |
| ingress-nginx                   | https://kubernetes.github.io/ingress-nginx                   | ingress-nginx                   | 4.10.1        |
| external-dns                    | https://kubernetes-sigs.github.io/external-dns               | external-dns                    | 1.14.4        |
| external-secrets                | https://charts.external-secrets.io                           | external-secrets                | 0.10.5        |
| oauth2-proxy                    | https://oauth2-proxy.github.io/manifests                     | oauth2-proxy                    | 7.7.22        |
| aqua                            | https://aquasecurity.github.io/helm-charts/                  | trivy-operator                  | 0.25.0        |
| kyverno                         | https://kyverno.github.io/kyverno/                           | kyverno                         | 3.2.7         |
| policy-reporter                 | https://kyverno.github.io/policy-reporter                    | policy-reporter                 | 2.24.2        |
| projectcapsule                  | https://projectcapsule.github.io/charts                      | capsule                         | 0.7.2         |
| stakater                        | https://stakater.github.io/stakater-charts                   | reloader                        | 1.0.115       |
| nfs-subdir-external-provisioner | https://kubernetes-sigs.github.io/nfs-subdir-external-provisioner | nfs-subdir-external-provisioner | 4.0.18        |
| harbor                          | https://helm.goharbor.io                                     | harbor                          | 1.16.0        |
| grafana                         | https://grafana.github.io/helm-charts                        | grafana-agent                   | 0.42.0        |
| prometheus-community            | https://prometheus-community.github.io/helm-charts           | kube-prometheus-stack           | 59.1.0        |
| grafana                         | https://grafana.github.io/helm-charts                        | loki                            | 5.48.0        |
| grafana                         | https://grafana.github.io/helm-charts                        | promtail                        | 6.15.5        |
| grafana                         | https://grafana.github.io/helm-charts                        | tempo                           | 1.8.0         |
| strimzi                         | https://strimzi.io/charts/                                   | strimzi-kafka-operator          | 0.42.0        |
| kafka-ui                        | https://provectus.github.io/kafka-ui-charts                  | kafka-ui                        | 0.7.6         |
| fairwinds-stable                | https://charts.fairwinds.com/stable                          | vpa                             | 4.7.1         |
| fairwinds-stable                | https://charts.fairwinds.com/stable                          | goldilocks                      | 9.0.1         |

## How to install a new tool via helm chart

1. Get below infomation:
   1. helm repo name
   2. helm repo URL
   3. helm chart name
   4. helm chart version
2. Download the helm chart and push to harbor with above infomation using [This workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-pull-push-to-harbor.yml)
3. If this tool will be installed in a new namespace, create namespace YAML manifest under base/helm-charts/base-ns/
4. add the folder and values.yaml file of this tool
5. add `helm diff` part to build workflow
6. add `helm upgrade` part to deploy workflow
7. push code to github toi trigger the workflow to install it. 

## How to uninstall a helm release

Use [This workflow](https://github.com/hangx969/local-k8s-platform-tools/actions/workflows/workflow-uninstall.yml), provide release name and namespace to uninstall it
