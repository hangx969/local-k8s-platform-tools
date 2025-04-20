{{- define "commonparameters.labels" -}}
helm.sh/chart: {{ printf "%s-%s" .Chart.Name .Chart.Version | quote }}
app.kubernetes.io/version: {{ .Values.commonparameters.apicurio_registry.image.tag | quote }}
{{ include "apicurio-registry.selectorLabels" . }}
{{- end }}

{{- define "apicurio-registry.selectorLabels" -}}
app.kubernetes.io/name: apicurio-schema-registry
app.kubernetes.io/instance: apicurio-registry
{{- end }}