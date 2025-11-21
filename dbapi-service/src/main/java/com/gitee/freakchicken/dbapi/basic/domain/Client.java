package com.gitee.freakchicken.dbapi.basic.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("client")
public class Client implements Serializable {
    @TableId
    String id;

    @TableField
    String secret;

    @TableField
    String name;

    @TableField
    String note;

    @TableField
    String expireDesc;

    @TableField
    Long expireDuration;

    @TableField
    String token;

    @TableField("expire_at")
    Long expireAt;

    @TableField("create_user_id")
    Integer createUserId;

    @TableField("create_time")
    String createTime;

    @TableField("update_time")
    String updateTime;

    public void setId(String id) {
        this.id = id;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setExpireDesc(String expireDesc) {
        this.expireDesc = expireDesc;
    }

    public void setExpireDuration(Long expireDuration) {
        this.expireDuration = expireDuration;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client))
            return false;
        Client other = (Client)o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$secret = getSecret(), other$secret = other.getSecret();
        if ((this$secret == null) ? (other$secret != null) : !this$secret.equals(other$secret))
            return false;
        Object this$name = getName(), other$name = other.getName();
        if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
            return false;
        Object this$note = getNote(), other$note = other.getNote();
        if ((this$note == null) ? (other$note != null) : !this$note.equals(other$note))
            return false;
        Object this$expireDesc = getExpireDesc(), other$expireDesc = other.getExpireDesc();
        if ((this$expireDesc == null) ? (other$expireDesc != null) : !this$expireDesc.equals(other$expireDesc))
            return false;
        Object this$expireDuration = getExpireDuration(), other$expireDuration = other.getExpireDuration();
        if ((this$expireDuration == null) ? (other$expireDuration != null) : !this$expireDuration.equals(other$expireDuration))
            return false;
        Object this$token = getToken(), other$token = other.getToken();
        if ((this$token == null) ? (other$token != null) : !this$token.equals(other$token))
            return false;
        Object this$expireAt = getExpireAt(), other$expireAt = other.getExpireAt();
        if ((this$expireAt == null) ? (other$expireAt != null) : !this$expireAt.equals(other$expireAt))
            return false;
        Object this$createUserId = getCreateUserId(), other$createUserId = other.getCreateUserId();
        if ((this$createUserId == null) ? (other$createUserId != null) : !this$createUserId.equals(other$createUserId))
            return false;
        Object this$createTime = getCreateTime(), other$createTime = other.getCreateTime();
        if ((this$createTime == null) ? (other$createTime != null) : !this$createTime.equals(other$createTime))
            return false;
        Object this$updateTime = getUpdateTime(), other$updateTime = other.getUpdateTime();
        return !((this$updateTime == null) ? (other$updateTime != null) : !this$updateTime.equals(other$updateTime));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Client;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $secret = getSecret();
        result = result * 59 + (($secret == null) ? 43 : $secret.hashCode());
        Object $name = getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        Object $note = getNote();
        result = result * 59 + (($note == null) ? 43 : $note.hashCode());
        Object $expireDesc = getExpireDesc();
        result = result * 59 + (($expireDesc == null) ? 43 : $expireDesc.hashCode());
        Object $expireDuration = getExpireDuration();
        result = result * 59 + (($expireDuration == null) ? 43 : $expireDuration.hashCode());
        Object $token = getToken();
        result = result * 59 + (($token == null) ? 43 : $token.hashCode());
        Object $expireAt = getExpireAt();
        result = result * 59 + (($expireAt == null) ? 43 : $expireAt.hashCode());
        Object $createUserId = getCreateUserId();
        result = result * 59 + (($createUserId == null) ? 43 : $createUserId.hashCode());
        Object $createTime = getCreateTime();
        result = result * 59 + (($createTime == null) ? 43 : $createTime.hashCode());
        Object $updateTime = getUpdateTime();
        return result * 59 + (($updateTime == null) ? 43 : $updateTime.hashCode());
    }

    public String toString() {
        return "Client(id=" + getId() + ", secret=" + getSecret() + ", name=" + getName() + ", note=" + getNote() + ", expireDesc=" + getExpireDesc() + ", expireDuration=" + getExpireDuration() + ", token=" + getToken() + ", expireAt=" + getExpireAt() + ", createUserId=" + getCreateUserId() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ")";
    }

    public String getId() {
        return this.id;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getName() {
        return this.name;
    }

    public String getNote() {
        return this.note;
    }

    public String getExpireDesc() {
        return this.expireDesc;
    }

    public Long getExpireDuration() {
        return this.expireDuration;
    }

    public String getToken() {
        return this.token;
    }

    public Long getExpireAt() {
        return this.expireAt;
    }

    public Integer getCreateUserId() {
        return this.createUserId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }
}
