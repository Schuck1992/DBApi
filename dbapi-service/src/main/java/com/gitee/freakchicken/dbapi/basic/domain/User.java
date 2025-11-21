package com.gitee.freakchicken.dbapi.basic.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("user")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;

    @TableField
    String username;

    @TableField
    String password;

    @TableField(exist = false)
    String token;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User))
            return false;
        User other = (User)o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$username = getUsername(), other$username = other.getUsername();
        if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username))
            return false;
        Object this$password = getPassword(), other$password = other.getPassword();
        if ((this$password == null) ? (other$password != null) : !this$password.equals(other$password))
            return false;
        Object this$token = getToken(), other$token = other.getToken();
        return !((this$token == null) ? (other$token != null) : !this$token.equals(other$token));
    }

    protected boolean canEqual(Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        int PRIME = 59;
        result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $username = getUsername();
        result = result * 59 + (($username == null) ? 43 : $username.hashCode());
        Object $password = getPassword();
        result = result * 59 + (($password == null) ? 43 : $password.hashCode());
        Object $token = getToken();
        return result * 59 + (($token == null) ? 43 : $token.hashCode());
    }

    public String toString() {
        return "User(id=" + getId() + ", username=" + getUsername() + ", password=" + getPassword() + ", token=" + getToken() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getToken() {
        return this.token;
    }
}
