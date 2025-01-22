# Installing cli
kubectl krew install kyverno

# Running tests
kubectl kyverno test . -f kyverno-test-image.yaml
kubectl kyverno test . -f kyverno-test-resource.yaml
kubectl kyverno test . -f kyverno-test-mutate-security.yaml
kubectl kyverno test . -f kyverno-test-validate-security.yaml
kubectl kyverno test . -f kyverno-test-validate-security-baseline.yaml
