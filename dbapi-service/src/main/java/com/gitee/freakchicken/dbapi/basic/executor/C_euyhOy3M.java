package com.gitee.freakchicken.dbapi.basic.executor;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.dto.ApiSqlDto;
import com.gitee.freakchicken.dbapi.basic.dto.SQLTaskDto;
import com.gitee.freakchicken.dbapi.basic.service.C_PPKGzyLn;
import com.gitee.freakchicken.dbapi.basic.util.C_IlxBH4Hk;
import com.gitee.freakchicken.dbapi.basic.util.C_TfP8QHJa;
import com.gitee.freakchicken.dbapi.basic.util.C_khZIipIa;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import com.gitee.freakchicken.dbapi.plugin.TransformPlugin;
import com.github.freakchick.orange.SqlMeta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C_euyhOy3M implements C_pEATdIJE {
    private static final Logger log = LoggerFactory.getLogger(C_euyhOy3M.class);

    @Autowired
    C_PPKGzyLn gf_hjnTE1ME;

    public Object execute(JSONObject p_wn1bEIFI, Map<String, Object> p_v3UpxmQ3) throws Exception {
        SQLTaskDto lf_8KYRgl7I = (SQLTaskDto)p_wn1bEIFI.toJavaObject(SQLTaskDto.class);
        DataSource lf_IIiEl7m7 = this.gf_hjnTE1ME.m_ggRKn4xy(lf_8KYRgl7I.getDatasourceId());
        if (lf_IIiEl7m7 == null)
            throw new RuntimeException("Datasource not exists!");
        List<ApiSqlDto> lf_LpjZsSAF = lf_8KYRgl7I.getSqlList();
        DruidPooledConnection lf_WZgu5dSl = C_khZIipIa.m_vb8mHVEp(lf_IIiEl7m7);
        List<Object> lf_JPtNFzWp = m_eiPf2jU2((Connection)lf_WZgu5dSl, lf_LpjZsSAF, p_v3UpxmQ3, lf_8KYRgl7I.getTransaction().booleanValue());
        for (int lf_tWY5UEp9 = 0; lf_tWY5UEp9 < lf_LpjZsSAF.size(); lf_tWY5UEp9++) {
            ApiSqlDto lf_0zVfWP2s = lf_LpjZsSAF.get(lf_tWY5UEp9);
            Object lf_6TLSVCiN = lf_JPtNFzWp.get(lf_tWY5UEp9);
            if (lf_6TLSVCiN instanceof Iterable && StringUtils.isNotBlank(lf_0zVfWP2s.getTransformPlugin())) {
                log.info("transform plugin execute");
                List<JSONObject> lf_eoOYtYlZ = (List<JSONObject>)lf_6TLSVCiN;
                TransformPlugin lf_LNxneedM = PluginManager.getTransformPlugin(lf_0zVfWP2s.getTransformPlugin());
                Object lf_IitJOsZI = lf_LNxneedM.transform(lf_eoOYtYlZ, lf_0zVfWP2s.getTransformPluginParam());
                lf_JPtNFzWp.set(lf_tWY5UEp9, lf_IitJOsZI);
            }
        }
        return (lf_JPtNFzWp.size() == 1) ? lf_JPtNFzWp.get(0) : lf_JPtNFzWp;
    }

    public List<Object> m_eiPf2jU2(Connection p_fAJ7jnOD, List<ApiSqlDto> p_cJjhpuaF, Map<String, Object> p_qknujAk7, boolean p_JfBUAw6X) {
        List<Object> lf_DxlQBI6E = new ArrayList();
        try {
            if (p_JfBUAw6X) {
                p_fAJ7jnOD.setAutoCommit(false);
            } else {
                p_fAJ7jnOD.setAutoCommit(true);
            }
            for (ApiSqlDto lf_Z3bi7cn7 : p_cJjhpuaF) {
                SqlMeta lf_Zk5EyZJM = C_IlxBH4Hk.m_nqOfskey().parse(lf_Z3bi7cn7.getSqlText(), p_qknujAk7);
                Object lf_TnfF33ip = C_TfP8QHJa.m_MYbYmrjL(p_fAJ7jnOD, lf_Zk5EyZJM.getSql(), lf_Zk5EyZJM.getJdbcParamValues());
                lf_DxlQBI6E.add(lf_TnfF33ip);
            }
            if (p_JfBUAw6X)
                p_fAJ7jnOD.commit();
            return lf_DxlQBI6E;
        } catch (Exception e) {
            try {
                if (p_JfBUAw6X)
                    p_fAJ7jnOD.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            if (p_fAJ7jnOD != null)
                try {
                    p_fAJ7jnOD.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
