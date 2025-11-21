package com.gitee.freakchicken.dbapi.basic.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C_TfP8QHJa {
    private static final Logger log = LoggerFactory.getLogger(C_TfP8QHJa.class);

    public static ResultSet m_JoY60hFE(String p_Bdc9CGtI, Connection p_rbr6Ygvj) throws SQLException {
        PreparedStatement lf_MXFWQsAd = p_rbr6Ygvj.prepareStatement(p_Bdc9CGtI);
        ResultSet lf_r2HA0cyW = lf_MXFWQsAd.executeQuery();
        return lf_r2HA0cyW;
    }

    public static Connection m_Y5MYniFj(JdbcDataSource p_krAu1CR7) throws Exception {
        try {
            Class.forName(p_krAu1CR7.getDriver());
            String lf_fm5DpAu8 = p_krAu1CR7.isEdit_password() ? p_krAu1CR7.getPassword() : C_remwVx8I.m_9W4gMncX(p_krAu1CR7.getPassword());
            Connection lf_Cu2b8Ew1 = DriverManager.getConnection(p_krAu1CR7.getUrl(), p_krAu1CR7.getUsername(), lf_fm5DpAu8);
            log.info("successfully connected");
            return lf_Cu2b8Ew1;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Please check whether the jdbc driver jar is missing, if missed copy the jdbc jar file to lib dir. " + e.getMessage());
        }
    }

    public static List<String> m_HgOZQqxt(Connection p_YM4LhQtE, String p_1PYAm0ja) {
        List<String> lf_WCh1fJDT = new ArrayList<>();
        PreparedStatement lf_xKSDIQ44 = null;
        try {
            lf_xKSDIQ44 = p_YM4LhQtE.prepareStatement(p_1PYAm0ja);
            ResultSet lf_SwzJ7WMr = lf_xKSDIQ44.executeQuery();
            while (lf_SwzJ7WMr.next()) {
                String lf_mrrLZJDQ = lf_SwzJ7WMr.getString(1);
                lf_WCh1fJDT.add(lf_mrrLZJDQ);
            }
            return lf_WCh1fJDT;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            try {
                if (lf_xKSDIQ44 != null)
                    lf_xKSDIQ44.close();
                if (p_YM4LhQtE != null)
                    p_YM4LhQtE.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<JSONObject> m_d7uKhh1Z(Connection p_JNkyelyz, String p_2FsOuwUD, String p_pPsX0WQX) {
        List<JSONObject> lf_xnBpMZMk = new ArrayList<>();
        PreparedStatement lf_GAPTiAVd = null;
        try {
            String lf_ZBDmmuvE;
            switch (p_2FsOuwUD) {
                case "POSTGRESQL":
                    lf_ZBDmmuvE = "select * from \"" + p_pPsX0WQX + "\" where 1=2";
                    break;
                default:
                    lf_ZBDmmuvE = "select * from " + p_pPsX0WQX + " where 1=2";
                    break;
            }
            lf_GAPTiAVd = p_JNkyelyz.prepareStatement(lf_ZBDmmuvE);
            ResultSetMetaData lf_uIerUIFa = lf_GAPTiAVd.executeQuery().getMetaData();
            for (int lf_8qqsB2vl = 0; lf_8qqsB2vl < lf_uIerUIFa.getColumnCount(); lf_8qqsB2vl++) {
                JSONObject lf_fDhCon8t = new JSONObject();
                String lf_rbFzgq38 = lf_uIerUIFa.getColumnTypeName(lf_8qqsB2vl + 1);
                lf_fDhCon8t.put("fieldTypeName", lf_rbFzgq38);
                lf_fDhCon8t.put("TypeName", lf_rbFzgq38);
                lf_fDhCon8t.put("fieldJavaTypeName", lf_uIerUIFa.getColumnClassName(lf_8qqsB2vl + 1));
                String lf_wXPA9acp = lf_uIerUIFa.getColumnName(lf_8qqsB2vl + 1);
                if (lf_wXPA9acp.contains("."))
                    lf_wXPA9acp = lf_wXPA9acp.split("\\.")[1];
                lf_fDhCon8t.put("label", lf_wXPA9acp);
                lf_xnBpMZMk.add(lf_fDhCon8t);
            }
            return lf_xnBpMZMk;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            try {
                if (lf_GAPTiAVd != null)
                    lf_GAPTiAVd.close();
                if (p_JNkyelyz != null)
                    p_JNkyelyz.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object m_MYbYmrjL(Connection p_5M1srgTd, String p_RORxIAif, List<Object> p_KtpVyLN3) throws SQLException {
        log.debug(p_RORxIAif);
        log.debug(JSON.toJSONString(p_KtpVyLN3));
        PreparedStatement lf_xbecZ5IW = p_5M1srgTd.prepareStatement(p_RORxIAif);
        for (int lf_y26ULNzZ = 1; lf_y26ULNzZ <= p_KtpVyLN3.size(); lf_y26ULNzZ++)
            lf_xbecZ5IW.setObject(lf_y26ULNzZ, p_KtpVyLN3.get(lf_y26ULNzZ - 1));
        boolean lf_19GR75xy = lf_xbecZ5IW.execute();
        if (lf_19GR75xy) {
            ResultSet lf_oSqTdsU4 = lf_xbecZ5IW.getResultSet();
            int lf_CsnXtCoH = lf_oSqTdsU4.getMetaData().getColumnCount();
            List<String> lf_oOJh5m5c = new ArrayList<>();
            for (int lf_ZKKMVhVH = 1; lf_ZKKMVhVH <= lf_CsnXtCoH; lf_ZKKMVhVH++) {
                String lf_nDUyDJPA = lf_oSqTdsU4.getMetaData().getColumnLabel(lf_ZKKMVhVH);
                lf_oOJh5m5c.add(lf_nDUyDJPA);
            }
            List<JSONObject> lf_3jtFzShW = new ArrayList<>();
            while (lf_oSqTdsU4.next()) {
                JSONObject lf_tXESqgV1 = new JSONObject();
                lf_oOJh5m5c.stream().forEach(lambda_lf_clhEJqkH -> {
                    try {
                        Object lf_5Yq7VTV9 = lf_oSqTdsU4.getObject(lambda_lf_clhEJqkH);
                        lf_tXESqgV1.put(lambda_lf_clhEJqkH, lf_5Yq7VTV9);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                });
                lf_3jtFzShW.add(lf_tXESqgV1);
            }
            return lf_3jtFzShW;
        }
        int lf_edWHlZuH = lf_xbecZ5IW.getUpdateCount();
        return lf_edWHlZuH + " rows affected";
    }
}
