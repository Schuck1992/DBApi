package com.gitee.freakchicken.dbapi.basic.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("api_group")
public class Group implements Serializable {
    @TableId("id")
    String id;

    @TableField
    String name;

    @TableField("create_user_id")
    Integer createUserId;

    @TableField("create_time")
    String createTime;

    @TableField("update_time")
    String updateTime;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof Group))
            return false;
        Group other = (Group)o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$name = getName(), other$name = other.getName();
        if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
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
        return other instanceof Group;
    }

    public int hashCode() {
        int PRIME = 59;
        result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $name = getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        Object $createUserId = getCreateUserId();
        result = result * 59 + (($createUserId == null) ? 43 : $createUserId.hashCode());
        Object $createTime = getCreateTime();
        result = result * 59 + (($createTime == null) ? 43 : $createTime.hashCode());
        Object $updateTime = getUpdateTime();
        return result * 59 + (($updateTime == null) ? 43 : $updateTime.hashCode());
    }

    public String toString() {
        return "Group(id=" + getId() + ", name=" + getName() + ", createUserId=" + getCreateUserId() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ")";
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
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
