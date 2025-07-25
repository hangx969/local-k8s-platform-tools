export yaml_file='../monitoring/filebeat/filebeat.yaml'
export namespace='logging'

kubectl apply -f $yaml_file --kubeconfig $kubeconfig --namespace $namespace