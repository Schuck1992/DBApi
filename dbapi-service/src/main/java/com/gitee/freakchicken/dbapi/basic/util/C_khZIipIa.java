package com.gitee.freakchicken.dbapi.basic.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C_khZIipIa {
    private static final Logger log = LoggerFactory.getLogger(C_khZIipIa.class);

    static ConcurrentHashMap<String, DruidDataSource> gf_CluKlcpQ = new ConcurrentHashMap<>();

    public static DruidDataSource m_mIf1Qpn6(DataSource p_YkfpXrJC) {
        if (gf_CluKlcpQ.containsKey(p_YkfpXrJC.getId()))
            return gf_CluKlcpQ.get(p_YkfpXrJC.getId());
        JdbcDataSource lf_MaqpMLGs = p_YkfpXrJC.getJdbcDataSource();
        DruidDataSource lf_YaJf8Arn = new DruidDataSource();
        lf_YaJf8Arn.setName(p_YkfpXrJC.getName());
        lf_YaJf8Arn.setUrl(lf_MaqpMLGs.getUrl());
        lf_YaJf8Arn.setUsername(lf_MaqpMLGs.getUsername());
        lf_YaJf8Arn.setDriverClassName(lf_MaqpMLGs.getDriver());
        lf_YaJf8Arn.setConnectionErrorRetryAttempts(3);
        lf_YaJf8Arn.setBreakAfterAcquireFailure(true);
        try {
            lf_YaJf8Arn.setPassword(C_remwVx8I.m_9W4gMncX(lf_MaqpMLGs.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        gf_CluKlcpQ.put(p_YkfpXrJC.getId(), lf_YaJf8Arn);
        log.info("create druid datasource{}", p_YkfpXrJC.getName());
        return gf_CluKlcpQ.get(p_YkfpXrJC.getId());
    }

    public static void m_yNMei4Mn(String p_G1N2uQ2C) {
        if (gf_CluKlcpQ.containsKey(p_G1N2uQ2C)) {
            DruidDataSource lf_qw28trWA = gf_CluKlcpQ.get(p_G1N2uQ2C);
            gf_CluKlcpQ.remove(p_G1N2uQ2C);
            lf_qw28trWA.close();
            log.info("remove druid datasource: {}", lf_qw28trWA.getName());
        }
    }

    public static DruidPooledConnection m_vb8mHVEp(DataSource p_s49BhmTY) throws SQLException {
        DruidDataSource lf_Oqjl68dg = m_mIf1Qpn6(p_s49BhmTY);
        DruidPooledConnection lf_wDBZ7cHQ = lf_Oqjl68dg.getConnection();
        return lf_wDBZ7cHQ;
    }
}
