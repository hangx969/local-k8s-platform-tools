# define env
export capsule_version='0.6.2'
export capsule_repo=''
export capsule_ns='capsule-system'
export capsule_release_name='capsule'
# check if helm chart is existing in harbor


# pull helm chart if not existing
helm repo add capsule $capsule_repo
helm repo update capsule


