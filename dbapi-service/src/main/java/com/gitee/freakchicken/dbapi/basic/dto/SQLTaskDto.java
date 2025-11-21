package com.gitee.freakchicken.dbapi.basic.dto;

import java.util.List;

public class SQLTaskDto {
    String datasourceId;

    Boolean transaction;

    List<ApiSqlDto> sqlList;

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    public void setTransaction(Boolean transaction) {
        this.transaction = transaction;
    }

    public void setSqlList(List<ApiSqlDto> sqlList) {
        this.sqlList = sqlList;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SQLTaskDto))
            return false;
        SQLTaskDto other = (SQLTaskDto)o;
        if (!other.canEqual(this))
            return false;
        Object this$datasourceId = getDatasourceId(), other$datasourceId = other.getDatasourceId();
        if ((this$datasourceId == null) ? (other$datasourceId != null) : !this$datasourceId.equals(other$datasourceId))
            return false;
        Object this$transaction = getTransaction(), other$transaction = other.getTransaction();
        if ((this$transaction == null) ? (other$transaction != null) : !this$transaction.equals(other$transaction))
            return false;
        Object<ApiSqlDto> this$sqlList = (Object<ApiSqlDto>)getSqlList(), other$sqlList = (Object<ApiSqlDto>)other.getSqlList();
        return !((this$sqlList == null) ? (other$sqlList != null) : !this$sqlList.equals(other$sqlList));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SQLTaskDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $datasourceId = getDatasourceId();
        result = result * 59 + (($datasourceId == null) ? 43 : $datasourceId.hashCode());
        Object $transaction = getTransaction();
        result = result * 59 + (($transaction == null) ? 43 : $transaction.hashCode());
        Object<ApiSqlDto> $sqlList = (Object<ApiSqlDto>)getSqlList();
        return result * 59 + (($sqlList == null) ? 43 : $sqlList.hashCode());
    }

    public String toString() {
        return "SQLTaskDto(datasourceId=" + getDatasourceId() + ", transaction=" + getTransaction() + ", sqlList=" + getSqlList() + ")";
    }

    public String getDatasourceId() {
        return this.datasourceId;
    }

    public Boolean getTransaction() {
        return this.transaction;
    }

    public List<ApiSqlDto> getSqlList() {
        return this.sqlList;
    }
}
