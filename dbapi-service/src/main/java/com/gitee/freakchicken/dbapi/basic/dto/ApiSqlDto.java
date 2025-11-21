package com.gitee.freakchicken.dbapi.basic.dto;

public class ApiSqlDto {
    String sqlText;

    String transformPlugin;

    String transformPluginParam;

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public void setTransformPlugin(String transformPlugin) {
        this.transformPlugin = transformPlugin;
    }

    public void setTransformPluginParam(String transformPluginParam) {
        this.transformPluginParam = transformPluginParam;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ApiSqlDto))
            return false;
        ApiSqlDto other = (ApiSqlDto)o;
        if (!other.canEqual(this))
            return false;
        Object this$sqlText = getSqlText(), other$sqlText = other.getSqlText();
        if ((this$sqlText == null) ? (other$sqlText != null) : !this$sqlText.equals(other$sqlText))
            return false;
        Object this$transformPlugin = getTransformPlugin(), other$transformPlugin = other.getTransformPlugin();
        if ((this$transformPlugin == null) ? (other$transformPlugin != null) : !this$transformPlugin.equals(other$transformPlugin))
            return false;
        Object this$transformPluginParam = getTransformPluginParam(), other$transformPluginParam = other.getTransformPluginParam();
        return !((this$transformPluginParam == null) ? (other$transformPluginParam != null) : !this$transformPluginParam.equals(other$transformPluginParam));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiSqlDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $sqlText = getSqlText();
        result = result * 59 + (($sqlText == null) ? 43 : $sqlText.hashCode());
        Object $transformPlugin = getTransformPlugin();
        result = result * 59 + (($transformPlugin == null) ? 43 : $transformPlugin.hashCode());
        Object $transformPluginParam = getTransformPluginParam();
        return result * 59 + (($transformPluginParam == null) ? 43 : $transformPluginParam.hashCode());
    }

    public String toString() {
        return "ApiSqlDto(sqlText=" + getSqlText() + ", transformPlugin=" + getTransformPlugin() + ", transformPluginParam=" + getTransformPluginParam() + ")";
    }

    public String getSqlText() {
        return this.sqlText;
    }

    public String getTransformPlugin() {
        return this.transformPlugin;
    }

    public String getTransformPluginParam() {
        return this.transformPluginParam;
    }
}
