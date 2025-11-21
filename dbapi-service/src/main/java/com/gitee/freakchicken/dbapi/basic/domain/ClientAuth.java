package com.gitee.freakchicken.dbapi.basic.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("client_auth")
public class ClientAuth implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;

    @TableField("client_id")
    String clientId;

    @TableField("group_id")
    String groupId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClientAuth))
            return false;
        ClientAuth other = (ClientAuth)o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$clientId = getClientId(), other$clientId = other.getClientId();
        if ((this$clientId == null) ? (other$clientId != null) : !this$clientId.equals(other$clientId))
            return false;
        Object this$groupId = getGroupId(), other$groupId = other.getGroupId();
        return !((this$groupId == null) ? (other$groupId != null) : !this$groupId.equals(other$groupId));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ClientAuth;
    }

    public int hashCode() {
        int PRIME = 59;
        result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $clientId = getClientId();
        result = result * 59 + (($clientId == null) ? 43 : $clientId.hashCode());
        Object $groupId = getGroupId();
        return result * 59 + (($groupId == null) ? 43 : $groupId.hashCode());
    }

    public String toString() {
        return "ClientAuth(id=" + getId() + ", clientId=" + getClientId() + ", groupId=" + getGroupId() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getGroupId() {
        return this.groupId;
    }
}
