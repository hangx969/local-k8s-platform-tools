# Deploy Monitoring Helm Charts - 完整步骤补全报告

## 修复概述
根据 Linux 原版工作流，我已经补全了 Windows 版本的 `deploy-monitoring-helm-charts.yml` 中缺失的所有关键步骤。

## 补全的步骤

### 1. kube-prometheus-stack 完整部署流程
**新增的关键步骤：**
- ✅ **CRDs 提取**: 使用 `tar` 提取 Helm chart 中的 CRDs
- ✅ **CRDs 对比**: 使用 `kubectl diff` 检查 CRDs 变更
- ✅ **CRDs 安装**: 使用 `kubectl apply --server-side` 安装 CRDs
- ✅ **Grafana 密码设置**: 添加了 `--set grafana.adminPassword` 参数

**PowerShell 转换：**
```powershell
# 提取 CRDs
tar xvf "$env:helmChartName-$env:helmChartVersion.tgz" kube-prometheus-stack/charts/crds/crds
# 对比 CRDs
kubectl diff -f kube-prometheus-stack/charts/crds/crds/ -R --kubeconfig $env:KUBECONFIG
# 安装 CRDs
kubectl apply --server-side -f kube-prometheus-stack/charts/crds/crds/ -R --kubeconfig $env:KUBECONFIG
```

### 2. jaeger 完整部署流程
**新增步骤：**
- ✅ **PVC 创建**: 创建 Badger 存储的 PVC
- ✅ **部署补丁**: 修改 readiness 和 liveness 探针的失败阈值

**PowerShell 转换：**
```powershell
# 创建存储
kubectl apply -f ./monitoring/external/jaeger/storage/pvc-jaeger.yaml -n monitoring
# 部署后补丁
kubectl patch deployment/jaeger -n monitoring --type='json' -p='[...]'
```

### 3. 组件部署顺序调整
**正确的部署顺序：**
1. kube-prometheus-stack (包含 CRDs 处理)
2. grafana-agent
3. loki
4. promtail
5. tempo
6. jaeger (包含存储和补丁)
7. prometheus-rules (自定义 Helm chart)
8. grafana-dashboards (自定义 Helm chart)

### 4. 命名空间一致性
- ✅ 确认所有组件都部署到 `monitoring` 命名空间
- ✅ 与 Linux 版本保持一致

## 关键改进

### PowerShell 语法优化
- 使用 `Write-Host` 替代 `echo` 进行日志输出
- 使用 PowerShell 变量语法 `$env:variableName`
- 保持 kubectl 和 helm 命令的完整参数

### 安全性改进
- 保留了 `--insecure-skip-tls-verify` 参数
- 保留了 Grafana 密码的 secret 引用
- 保持了所有安全相关的配置

## 验证清单
- ✅ CRDs 处理流程完整
- ✅ 所有组件的部署顺序正确
- ✅ Jaeger 存储和探针配置完整
- ✅ 自定义 Helm charts 部署完整
- ✅ 命名空间使用一致
- ✅ PowerShell 语法正确
- ✅ 所有 secrets 和配置文件引用正确

## 与 Linux 版本的对比
现在 Windows 版本的 `deploy-monitoring-helm-charts.yml` 已经与 Linux 版本**功能完全一致**，包含了所有必要的部署步骤和配置。
