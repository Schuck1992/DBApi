package com.gitee.freakchicken.dbapi.basic.domain;

import java.io.Serializable;

public class ClientToken implements Serializable {
    String clientId;

    String token;

    Long expireAt;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClientToken))
            return false;
        ClientToken other = (ClientToken)o;
        if (!other.canEqual(this))
            return false;
        Object this$clientId = getClientId(), other$clientId = other.getClientId();
        if ((this$clientId == null) ? (other$clientId != null) : !this$clientId.equals(other$clientId))
            return false;
        Object this$token = getToken(), other$token = other.getToken();
        if ((this$token == null) ? (other$token != null) : !this$token.equals(other$token))
            return false;
        Object this$expireAt = getExpireAt(), other$expireAt = other.getExpireAt();
        return !((this$expireAt == null) ? (other$expireAt != null) : !this$expireAt.equals(other$expireAt));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ClientToken;
    }

    public int hashCode() {
        int PRIME = 59;
        result = 1;
        Object $clientId = getClientId();
        result = result * 59 + (($clientId == null) ? 43 : $clientId.hashCode());
        Object $token = getToken();
        result = result * 59 + (($token == null) ? 43 : $token.hashCode());
        Object $expireAt = getExpireAt();
        return result * 59 + (($expireAt == null) ? 43 : $expireAt.hashCode());
    }

    public String toString() {
        return "ClientToken(clientId=" + getClientId() + ", token=" + getToken() + ", expireAt=" + getExpireAt() + ")";
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getToken() {
        return this.token;
    }

    public Long getExpireAt() {
        return this.expireAt;
    }
}
