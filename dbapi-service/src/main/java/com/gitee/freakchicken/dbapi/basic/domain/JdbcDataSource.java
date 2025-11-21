package com.gitee.freakchicken.dbapi.basic.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class JdbcDataSource {
    private String type;

    private String url;

    private String driver;

    private String username;

    private String password;

    private String tableSql;

    @JSONField(serialize = false)
    private boolean isEdit_password;

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTableSql(String tableSql) {
        this.tableSql = tableSql;
    }

    public void setEdit_password(boolean isEdit_password) {
        this.isEdit_password = isEdit_password;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JdbcDataSource))
            return false;
        JdbcDataSource other = (JdbcDataSource)o;
        if (!other.canEqual(this))
            return false;
        Object this$type = getType(), other$type = other.getType();
        if ((this$type == null) ? (other$type != null) : !this$type.equals(other$type))
            return false;
        Object this$url = getUrl(), other$url = other.getUrl();
        if ((this$url == null) ? (other$url != null) : !this$url.equals(other$url))
            return false;
        Object this$driver = getDriver(), other$driver = other.getDriver();
        if ((this$driver == null) ? (other$driver != null) : !this$driver.equals(other$driver))
            return false;
        Object this$username = getUsername(), other$username = other.getUsername();
        if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username))
            return false;
        Object this$password = getPassword(), other$password = other.getPassword();
        if ((this$password == null) ? (other$password != null) : !this$password.equals(other$password))
            return false;
        Object this$tableSql = getTableSql(), other$tableSql = other.getTableSql();
        return ((this$tableSql == null) ? (other$tableSql != null) : !this$tableSql.equals(other$tableSql)) ? false : (!(isEdit_password() != other.isEdit_password()));
    }

    protected boolean canEqual(Object other) {
        return other instanceof JdbcDataSource;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $type = getType();
        result = result * 59 + (($type == null) ? 43 : $type.hashCode());
        Object $url = getUrl();
        result = result * 59 + (($url == null) ? 43 : $url.hashCode());
        Object $driver = getDriver();
        result = result * 59 + (($driver == null) ? 43 : $driver.hashCode());
        Object $username = getUsername();
        result = result * 59 + (($username == null) ? 43 : $username.hashCode());
        Object $password = getPassword();
        result = result * 59 + (($password == null) ? 43 : $password.hashCode());
        Object $tableSql = getTableSql();
        result = result * 59 + (($tableSql == null) ? 43 : $tableSql.hashCode());
        return result * 59 + (isEdit_password() ? 79 : 97);
    }

    public String toString() {
        return "JdbcDataSource(type=" + getType() + ", url=" + getUrl() + ", driver=" + getDriver() + ", username=" + getUsername() + ", password=" + getPassword() + ", tableSql=" + getTableSql() + ", isEdit_password=" + isEdit_password() + ")";
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDriver() {
        return this.driver;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getTableSql() {
        return this.tableSql;
    }

    public boolean isEdit_password() {
        return this.isEdit_password;
    }
}
