package com.gitee.freakchicken.dbapi.basic.domain;

public class ApiDto {
    String id;

    String name;

    String groupName;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ApiDto))
            return false;
        ApiDto other = (ApiDto)o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$name = getName(), other$name = other.getName();
        if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
            return false;
        Object this$groupName = getGroupName(), other$groupName = other.getGroupName();
        return !((this$groupName == null) ? (other$groupName != null) : !this$groupName.equals(other$groupName));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiDto;
    }

    public int hashCode() {
        int PRIME = 59;
        result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $name = getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        Object $groupName = getGroupName();
        return result * 59 + (($groupName == null) ? 43 : $groupName.hashCode());
    }

    public String toString() {
        return "ApiDto(id=" + getId() + ", name=" + getName() + ", groupName=" + getGroupName() + ")";
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGroupName() {
        return this.groupName;
    }
}
