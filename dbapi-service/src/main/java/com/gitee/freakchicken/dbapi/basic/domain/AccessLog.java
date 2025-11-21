package com.gitee.freakchicken.dbapi.basic.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("access_log")
public class AccessLog {
    @TableId("id")
    private String id;

    @TableField
    private String url;

    @TableField
    private int status;

    @TableField
    private long duration;

    @TableField
    private long timestamp;

    @TableField
    private String ip;

    @TableField("client_id")
    private String clientId;

    @TableField("api_id")
    private String apiId;

    @TableField
    private String error;

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AccessLog))
            return false;
        AccessLog other = (AccessLog)o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$url = getUrl(), other$url = other.getUrl();
        if ((this$url == null) ? (other$url != null) : !this$url.equals(other$url))
            return false;
        if (getStatus() != other.getStatus())
            return false;
        if (getDuration() != other.getDuration())
            return false;
        if (getTimestamp() != other.getTimestamp())
            return false;
        Object this$ip = getIp(), other$ip = other.getIp();
        if ((this$ip == null) ? (other$ip != null) : !this$ip.equals(other$ip))
            return false;
        Object this$clientId = getClientId(), other$clientId = other.getClientId();
        if ((this$clientId == null) ? (other$clientId != null) : !this$clientId.equals(other$clientId))
            return false;
        Object this$apiId = getApiId(), other$apiId = other.getApiId();
        if ((this$apiId == null) ? (other$apiId != null) : !this$apiId.equals(other$apiId))
            return false;
        Object this$error = getError(), other$error = other.getError();
        return !((this$error == null) ? (other$error != null) : !this$error.equals(other$error));
    }

    protected boolean canEqual(Object other) {
        return other instanceof AccessLog;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $url = getUrl();
        result = result * 59 + (($url == null) ? 43 : $url.hashCode());
        result = result * 59 + getStatus();
        long $duration = getDuration();
        result = result * 59 + (int)($duration >>> 32L ^ $duration);
        long $timestamp = getTimestamp();
        result = result * 59 + (int)($timestamp >>> 32L ^ $timestamp);
        Object $ip = getIp();
        result = result * 59 + (($ip == null) ? 43 : $ip.hashCode());
        Object $clientId = getClientId();
        result = result * 59 + (($clientId == null) ? 43 : $clientId.hashCode());
        Object $apiId = getApiId();
        result = result * 59 + (($apiId == null) ? 43 : $apiId.hashCode());
        Object $error = getError();
        return result * 59 + (($error == null) ? 43 : $error.hashCode());
    }

    public String toString() {
        return "AccessLog(id=" + getId() + ", url=" + getUrl() + ", status=" + getStatus() + ", duration=" + getDuration() + ", timestamp=" + getTimestamp() + ", ip=" + getIp() + ", clientId=" + getClientId() + ", apiId=" + getApiId() + ", error=" + getError() + ")";
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public int getStatus() {
        return this.status;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getIp() {
        return this.ip;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getApiId() {
        return this.apiId;
    }

    public String getError() {
        return this.error;
    }
}
