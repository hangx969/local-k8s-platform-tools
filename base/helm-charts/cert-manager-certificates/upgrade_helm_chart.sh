#！/bin/bash

# define chart env
export helm_release_name='commoninfra-cert-manager-config'
export helm_ns='cert-manager'

# define working directory
export value_dir='/home/s0001969/Cloud/AzureDevOps-repo/local-k8s-platform-tools/helm/cert-manager-config'
export kubeconfig='/home/s0001969/Cloud/kubeconfig-local'

#print command before executing
set -x
cd $value_dir
helm upgrade -i $helm_release_name -n $helm_ns . -f ./values.yaml --insecure-skip-tls-verify --kubeconfig $kubeconfig
