#！/bin/bash

# define chart env
export helm_chart_version_new='4.10.1' # need to check the actual chart version format
export helm_repo_name='ingress-nginx'
export helm_repo_url='https://kubernetes.github.io/ingress-nginx'
export helm_chart_file_name='ingress-nginx' # need to check the actual file name prefix
export helm_release_name='ingress-nginx'
export helm_ns='ingress-nginx'

# define harbor env
export harbor_host='harbor.hanxux.local'
export harbor_project='platform-external'
export harbor_username='admin'
export harbor_passwd='Harbor12345'

# define working directory
export helm_chart_dir='/home/s0001969/Cloud/helm-charts'
export value_dir='/home/s0001969/Cloud/AzureDevOps-repo/local-k8s-platform-tools/external/ingress-nginx'
export kubeconfig='/home/s0001969/Cloud/kubeconfig-local'

#print command before executing
set -x

# pull helm chart
echo "...pulling helm chart..."

helm repo add --force-update $helm_repo_name $helm_repo_url
helm repo update $helm_repo_name

cd $helm_chart_dir
#检查目录下是否已下载helm chart文件
if [ -f $helm_chart_file_name-$helm_chart_version_new.tgz ]; then
    echo "helm chart file $helm_chart_file_name-$helm_chart_version_new.tgz exists."
else
    echo "helm chart file $helm_chart_file_name-$helm_chart_version_new.tgz does not exist, pulling"
    helm pull $helm_repo_name/$helm_chart_file_name --version $helm_chart_version_new
fi

# push to harbor
echo "...pushing helm chart to harbor..."

helm registry login $harbor_host --insecure --username $harbor_username --password $harbor_passwd
helm push $helm_chart_file_name-$helm_chart_version_new.tgz oci://$harbor_host/$harbor_project/ --insecure-skip-tls-verify

#upgrade helm chart from harbor
echo "...upgrade helm chart from harbor..."

helm upgrade -i $helm_release_name -n $helm_ns oci://$harbor_host/$harbor_project/$helm_chart_file_name --version $helm_chart_version_new -f $value_dir/values.yaml --insecure-skip-tls-verify --kubeconfig $kubeconfig
