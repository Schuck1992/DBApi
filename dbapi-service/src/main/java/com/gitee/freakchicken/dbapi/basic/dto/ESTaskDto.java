package com.gitee.freakchicken.dbapi.basic.dto;

public class ESTaskDto {
    String method;

    String endpoint;

    String body;

    String datasourceId;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ESTaskDto))
            return false;
        ESTaskDto other = (ESTaskDto)o;
        if (!other.canEqual(this))
            return false;
        Object this$method = getMethod(), other$method = other.getMethod();
        if ((this$method == null) ? (other$method != null) : !this$method.equals(other$method))
            return false;
        Object this$endpoint = getEndpoint(), other$endpoint = other.getEndpoint();
        if ((this$endpoint == null) ? (other$endpoint != null) : !this$endpoint.equals(other$endpoint))
            return false;
        Object this$body = getBody(), other$body = other.getBody();
        if ((this$body == null) ? (other$body != null) : !this$body.equals(other$body))
            return false;
        Object this$datasourceId = getDatasourceId(), other$datasourceId = other.getDatasourceId();
        return !((this$datasourceId == null) ? (other$datasourceId != null) : !this$datasourceId.equals(other$datasourceId));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ESTaskDto;
    }

    public int hashCode() {
        int PRIME = 59;
        result = 1;
        Object $method = getMethod();
        result = result * 59 + (($method == null) ? 43 : $method.hashCode());
        Object $endpoint = getEndpoint();
        result = result * 59 + (($endpoint == null) ? 43 : $endpoint.hashCode());
        Object $body = getBody();
        result = result * 59 + (($body == null) ? 43 : $body.hashCode());
        Object $datasourceId = getDatasourceId();
        return result * 59 + (($datasourceId == null) ? 43 : $datasourceId.hashCode());
    }

    public String toString() {
        return "ESTaskDto(method=" + getMethod() + ", endpoint=" + getEndpoint() + ", body=" + getBody() + ", datasourceId=" + getDatasourceId() + ")";
    }

    public String getMethod() {
        return this.method;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getBody() {
        return this.body;
    }

    public String getDatasourceId() {
        return this.datasourceId;
    }
}
