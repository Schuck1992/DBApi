package com.gitee.freakchicken.dbapi.basic.dto;

import com.gitee.freakchicken.dbapi.common.ApiPluginConfig;
import java.util.List;

public class ApiConfigDto {
    String id;

    String name;

    String note;

    String path;

    String params;

    Integer status;

    Integer previlege;

    String groupId;

    String contentType;

    String jsonParam;

    String taskType;

    String task;

    String createTime;

    String updateTime;

    List<ApiPluginConfig> plugins;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPrevilege(Integer previlege) {
        this.previlege = previlege;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setJsonParam(String jsonParam) {
        this.jsonParam = jsonParam;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setPlugins(List<ApiPluginConfig> plugins) {
        this.plugins = plugins;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ApiConfigDto))
            return false;
        ApiConfigDto other = (ApiConfigDto)o;
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
        Object this$path = getPath(), other$path = other.getPath();
        if ((this$path == null) ? (other$path != null) : !this$path.equals(other$path))
            return false;
        Object this$params = getParams(), other$params = other.getParams();
        if ((this$params == null) ? (other$params != null) : !this$params.equals(other$params))
            return false;
        Object this$status = getStatus(), other$status = other.getStatus();
        if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status))
            return false;
        Object this$previlege = getPrevilege(), other$previlege = other.getPrevilege();
        if ((this$previlege == null) ? (other$previlege != null) : !this$previlege.equals(other$previlege))
            return false;
        Object this$groupId = getGroupId(), other$groupId = other.getGroupId();
        if ((this$groupId == null) ? (other$groupId != null) : !this$groupId.equals(other$groupId))
            return false;
        Object this$contentType = getContentType(), other$contentType = other.getContentType();
        if ((this$contentType == null) ? (other$contentType != null) : !this$contentType.equals(other$contentType))
            return false;
        Object this$jsonParam = getJsonParam(), other$jsonParam = other.getJsonParam();
        if ((this$jsonParam == null) ? (other$jsonParam != null) : !this$jsonParam.equals(other$jsonParam))
            return false;
        Object this$taskType = getTaskType(), other$taskType = other.getTaskType();
        if ((this$taskType == null) ? (other$taskType != null) : !this$taskType.equals(other$taskType))
            return false;
        Object this$task = getTask(), other$task = other.getTask();
        if ((this$task == null) ? (other$task != null) : !this$task.equals(other$task))
            return false;
        Object this$createTime = getCreateTime(), other$createTime = other.getCreateTime();
        if ((this$createTime == null) ? (other$createTime != null) : !this$createTime.equals(other$createTime))
            return false;
        Object this$updateTime = getUpdateTime(), other$updateTime = other.getUpdateTime();
        if ((this$updateTime == null) ? (other$updateTime != null) : !this$updateTime.equals(other$updateTime))
            return false;
        Object<ApiPluginConfig> this$plugins = (Object<ApiPluginConfig>)getPlugins(), other$plugins = (Object<ApiPluginConfig>)other.getPlugins();
        return !((this$plugins == null) ? (other$plugins != null) : !this$plugins.equals(other$plugins));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiConfigDto;
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
        Object $path = getPath();
        result = result * 59 + (($path == null) ? 43 : $path.hashCode());
        Object $params = getParams();
        result = result * 59 + (($params == null) ? 43 : $params.hashCode());
        Object $status = getStatus();
        result = result * 59 + (($status == null) ? 43 : $status.hashCode());
        Object $previlege = getPrevilege();
        result = result * 59 + (($previlege == null) ? 43 : $previlege.hashCode());
        Object $groupId = getGroupId();
        result = result * 59 + (($groupId == null) ? 43 : $groupId.hashCode());
        Object $contentType = getContentType();
        result = result * 59 + (($contentType == null) ? 43 : $contentType.hashCode());
        Object $jsonParam = getJsonParam();
        result = result * 59 + (($jsonParam == null) ? 43 : $jsonParam.hashCode());
        Object $taskType = getTaskType();
        result = result * 59 + (($taskType == null) ? 43 : $taskType.hashCode());
        Object $task = getTask();
        result = result * 59 + (($task == null) ? 43 : $task.hashCode());
        Object $createTime = getCreateTime();
        result = result * 59 + (($createTime == null) ? 43 : $createTime.hashCode());
        Object $updateTime = getUpdateTime();
        result = result * 59 + (($updateTime == null) ? 43 : $updateTime.hashCode());
        Object<ApiPluginConfig> $plugins = (Object<ApiPluginConfig>)getPlugins();
        return result * 59 + (($plugins == null) ? 43 : $plugins.hashCode());
    }

    public String toString() {
        return "ApiConfigDto(id=" + getId() + ", name=" + getName() + ", note=" + getNote() + ", path=" + getPath() + ", params=" + getParams() + ", status=" + getStatus() + ", previlege=" + getPrevilege() + ", groupId=" + getGroupId() + ", contentType=" + getContentType() + ", jsonParam=" + getJsonParam() + ", taskType=" + getTaskType() + ", task=" + getTask() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ", plugins=" + getPlugins() + ")";
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

    public String getPath() {
        return this.path;
    }

    public String getParams() {
        return this.params;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getPrevilege() {
        return this.previlege;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getJsonParam() {
        return this.jsonParam;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public String getTask() {
        return this.task;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public List<ApiPluginConfig> getPlugins() {
        return this.plugins;
    }
}
