package com.gitee.freakchicken.dbapi.basic.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import java.io.Serializable;

@TableName("datasource")
public class DataSource implements Serializable {
    @TableId("id")
    String id;

    @TableField
    String name;

    @TableField
    String note;

    @TableField
    String type;

    @TableField
    String detail;

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

    public void setNote(String note) {
        this.note = note;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        if (!(o instanceof DataSource))
            return false;
        DataSource other = (DataSource)o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$name = getName(), other$name = other.getName();
        if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
            return false;
        Object this$note = getNote(), other$note = other.getNote();
        if ((this$note == null) ? (other$note != null) : !this$note.equals(other$note))
            return false;
        Object this$type = getType(), other$type = other.getType();
        if ((this$type == null) ? (other$type != null) : !this$type.equals(other$type))
            return false;
        Object this$detail = getDetail(), other$detail = other.getDetail();
        if ((this$detail == null) ? (other$detail != null) : !this$detail.equals(other$detail))
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
        return other instanceof DataSource;
    }

    public int hashCode() {
        int PRIME = 59;
        result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $name = getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        Object $note = getNote();
        result = result * 59 + (($note == null) ? 43 : $note.hashCode());
        Object $type = getType();
        result = result * 59 + (($type == null) ? 43 : $type.hashCode());
        Object $detail = getDetail();
        result = result * 59 + (($detail == null) ? 43 : $detail.hashCode());
        Object $createUserId = getCreateUserId();
        result = result * 59 + (($createUserId == null) ? 43 : $createUserId.hashCode());
        Object $createTime = getCreateTime();
        result = result * 59 + (($createTime == null) ? 43 : $createTime.hashCode());
        Object $updateTime = getUpdateTime();
        return result * 59 + (($updateTime == null) ? 43 : $updateTime.hashCode());
    }

    public String toString() {
        return "DataSource(id=" + getId() + ", name=" + getName() + ", note=" + getNote() + ", type=" + getType() + ", detail=" + getDetail() + ", createUserId=" + getCreateUserId() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ")";
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNote() {
        return this.note;
    }

    public String getType() {
        return this.type;
    }

    public String getDetail() {
        return this.detail;
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

    @JSONField(serialize = false)
    @JsonIgnore
    public boolean isJdbcType() {
        return Constants.DATASOURCE_TYPE_JDBC.equals(this.type);
    }

    @JSONField(serialize = false)
    @JsonIgnore
    public JdbcDataSource getJdbcDataSource() {
        JdbcDataSource jdbcDataSource = (JdbcDataSource)JSON.parseObject(this.detail, JdbcDataSource.class);
        return jdbcDataSource;
    }
}
