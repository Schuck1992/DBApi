package com.gitee.freakchicken.dbapi.basic.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gitee.freakchicken.dbapi.basic.executor.C_euyhOy3M;
import com.gitee.freakchicken.dbapi.basic.service.C_PPKGzyLn;
import com.gitee.freakchicken.dbapi.basic.service.C_oWM0hc5i;
import com.gitee.freakchicken.dbapi.basic.service.C_wVYsOSU8;
import com.gitee.freakchicken.dbapi.basic.util.C_GEUoaMz4;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import com.gitee.freakchicken.dbapi.common.ApiPluginConfig;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import com.gitee.freakchicken.dbapi.plugin.AlarmPlugin;
import com.gitee.freakchicken.dbapi.plugin.CachePlugin;
import com.gitee.freakchicken.dbapi.plugin.GlobalTransformPlugin;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class C_Yzpdk6am extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(C_Yzpdk6am.class);

    @Autowired
    C_wVYsOSU8 gf_ZXT1IgyP;

    @Autowired
    C_PPKGzyLn gf_TkwSsvyr;

    @Autowired
    C_oWM0hc5i gf_CFceU1kd;

    @Value("${dbapi.api.context}")
    String gf_iZEXh7CN;

    @Autowired
    C_euyhOy3M gf_742yW4Xs;

    protected void doGet(HttpServletRequest p_9shR3nPs, HttpServletResponse p_kA1Rzqxd) throws IOException {
        log.debug("servlet execute");
        String lf_5RUWo6ug = p_9shR3nPs.getRequestURI();
        lf_5RUWo6ug = lf_5RUWo6ug.substring(this.gf_iZEXh7CN.length() + 2);
        PrintWriter lf_y1Oxir4x = null;
        try {
            lf_y1Oxir4x = p_kA1Rzqxd.getWriter();
            ResponseDto lf_WoFQbu4b = m_7oFkXcXd(lf_5RUWo6ug, p_9shR3nPs, p_kA1Rzqxd);
            ApiConfig lf_GZDQ8CbU = (ApiConfig)p_9shR3nPs.getAttribute("pathApiConfig");
            Object lf_NyikkfoW = m_oIE3uO8U(lf_WoFQbu4b, lf_GZDQ8CbU);
            lf_y1Oxir4x.append(JSON.toJSONString(lf_NyikkfoW, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
        } catch (Exception e) {
            p_kA1Rzqxd.setStatus(500);
            ResponseDto lf_uPVMDxV0 = ResponseDto.fail(e.toString());
            ApiConfig lf_nnkRS5t8 = (ApiConfig)p_9shR3nPs.getAttribute("pathApiConfig");
            Object lf_IIz4pCWp = m_oIE3uO8U(lf_uPVMDxV0, lf_nnkRS5t8);
            lf_y1Oxir4x.append(JSON.toJSONString(lf_IIz4pCWp, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
            log.error(e.toString(), e);
        } finally {
            if (lf_y1Oxir4x != null)
                lf_y1Oxir4x.close();
        }
    }

    protected void doPost(HttpServletRequest p_HfgdsHky, HttpServletResponse p_ByzQ36MG) throws ServletException, IOException {
        doGet(p_HfgdsHky, p_ByzQ36MG);
    }

    public ResponseDto m_7oFkXcXd(String p_USqOnKsv, final HttpServletRequest p_ZDu8Ln2J, HttpServletResponse p_69QKJtGg) {
        final ApiConfig lf_IxERoF40 = this.gf_ZXT1IgyP.m_4GNK4h5M(p_USqOnKsv);
        if (lf_IxERoF40 == null) {
            p_69QKJtGg.setStatus(404);
            return ResponseDto.fail("Api not exists");
        }
        p_ZDu8Ln2J.setAttribute("pathApiConfig", lf_IxERoF40);
        try {
            Map<String, Object> lf_ij2kVlR5 = m_SV7ItUGr(p_ZDu8Ln2J, lf_IxERoF40);
            ApiPluginConfig lf_3uCBWaQk = lf_IxERoF40.getCachePlugin();
            if (lf_3uCBWaQk != null) {
                CachePlugin lf_Ny1GYgyu = PluginManager.getCachePlugin(lf_3uCBWaQk.getPluginName());
                Object lf_zbZ3Lgl9 = lf_Ny1GYgyu.get(lf_IxERoF40, lf_ij2kVlR5, lf_3uCBWaQk.getPluginParam());
                if (lf_zbZ3Lgl9 != null)
                    return ResponseDto.apiSuccess(lf_zbZ3Lgl9);
            }
            List<Object> lf_MUtUXKBa = new ArrayList();
            JSONArray lf_gA6VN5el = lf_IxERoF40.getTaskJson();
            for (int lf_1jnLUAYT = 0; lf_1jnLUAYT < lf_gA6VN5el.size(); lf_1jnLUAYT++) {
                C_euyhOy3M c_euyhOy3M;
                JSONObject lf_rSt8fK5Z = lf_gA6VN5el.getJSONObject(lf_1jnLUAYT);
                int lf_vt8aDjVM = lf_rSt8fK5Z.getIntValue("taskType");
                if (lf_vt8aDjVM == Constants.API_EXECUTOR_SQL) {
                    c_euyhOy3M = this.gf_742yW4Xs;
                } else if (lf_vt8aDjVM == Constants.API_EXECUTOR_HTTP) {
                    c_euyhOy3M = this.gf_742yW4Xs;
                } else if (lf_vt8aDjVM == Constants.API_EXECUTOR_ES) {
                    c_euyhOy3M = this.gf_742yW4Xs;
                } else {
                    throw new RuntimeException("Executor type unknown!");
                }
                Object lf_sX1LgUh8 = c_euyhOy3M.execute(lf_rSt8fK5Z, lf_ij2kVlR5);
                lf_MUtUXKBa.add(lf_sX1LgUh8);
            }
            Object lf_1G9s6wQa = (lf_MUtUXKBa.size() == 1) ? lf_MUtUXKBa.get(0) : lf_MUtUXKBa;
            if (lf_3uCBWaQk != null) {
                CachePlugin lf_mcqQVMSv = PluginManager.getCachePlugin(lf_3uCBWaQk.getPluginName());
                lf_mcqQVMSv.set(lf_IxERoF40, lf_ij2kVlR5, lf_1G9s6wQa, lf_3uCBWaQk.getPluginParam());
            }
            return ResponseDto.apiSuccess(lf_1G9s6wQa);
        } catch (Exception e) {
            List<ApiPluginConfig> lf_S3Rr3RkR = lf_IxERoF40.getAlarmPlugins();
            for (ApiPluginConfig lf_wt0eHabn : lf_S3Rr3RkR) {
                try {
                    final String lf_FGmQFP2d = lf_wt0eHabn.getPluginParam();
                    final AlarmPlugin lf_G4oHsvMa = PluginManager.getAlarmPlugin(lf_wt0eHabn.getPluginName());
                    C_GEUoaMz4.m_TF0xFtGb(new Runnable() {
                        public void run() {
                            lf_G4oHsvMa.alarm(e, lf_IxERoF40, p_ZDu8Ln2J, lf_FGmQFP2d);
                        }
                    });
                } catch (Exception error) {
                    log.error(lf_wt0eHabn.getPluginName() + " error!", error);
                }
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    private Map<String, Object> m_SV7ItUGr(HttpServletRequest p_efEj12Mr, ApiConfig p_u6Qrvek3) {
        String lf_lKROlugY = p_efEj12Mr.getContentType();
        if (lf_lKROlugY == null)
            lf_lKROlugY = "application/x-www-form-urlencoded";
        String[] lf_d0MH4Gna = lf_lKROlugY.split(";");
        String lf_kjvgQExm = lf_d0MH4Gna[0];
        Map<String, Object> lf_K4M58FCN = null;
        if (lf_kjvgQExm.equalsIgnoreCase("application/json")) {
            JSONObject lf_UwXTEKkN = m_RJDt7Xo6(p_efEj12Mr);
            lf_K4M58FCN = (Map<String, Object>)JSONObject.parseObject(lf_UwXTEKkN.toJSONString(), new TypeReference<Map<String, Object>>() {

            },  new com.alibaba.fastjson.parser.Feature[0]);
        } else if (lf_kjvgQExm.equalsIgnoreCase("application/x-www-form-urlencoded")) {
            if ("application/x-www-form-urlencoded".equalsIgnoreCase(p_u6Qrvek3.getContentType())) {
                lf_K4M58FCN = this.gf_CFceU1kd.m_K4T47eNY(p_efEj12Mr, p_u6Qrvek3);
            } else {
                throw new RuntimeException("This API only supports content-type: " + p_u6Qrvek3.getContentType() + ", but you use: " + lf_kjvgQExm);
            }
        } else {
            throw new RuntimeException("Content-type not supported: " + lf_kjvgQExm);
        }
        return lf_K4M58FCN;
    }

    private JSONObject m_RJDt7Xo6(HttpServletRequest p_BLYMDTqo) {
        try {
            InputStreamReader lf_fWIkQxMW = new InputStreamReader((InputStream)p_BLYMDTqo.getInputStream(), "utf-8");
            BufferedReader lf_zFGU6SBV = new BufferedReader(lf_fWIkQxMW);
            StringBuilder lf_cjffGxma = new StringBuilder();
            String lf_WF39JM1c = null;
            while ((lf_WF39JM1c = lf_zFGU6SBV.readLine()) != null)
                lf_cjffGxma.append(lf_WF39JM1c);
            lf_zFGU6SBV.close();
            JSONObject lf_Zf4tKPOr = JSON.parseObject(lf_cjffGxma.toString());
            return lf_Zf4tKPOr;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {}
        return null;
    }

    private Object m_oIE3uO8U(ResponseDto p_YkF6TEyB, ApiConfig p_A7p6sKx1) {
        if (p_A7p6sKx1 != null) {
            ApiPluginConfig lf_f3pS4Jbm = p_A7p6sKx1.getGlobalTransformPlugin();
            if (lf_f3pS4Jbm != null) {
                GlobalTransformPlugin lf_XfiVzHae = PluginManager.getGlobalTransformPlugin(lf_f3pS4Jbm.getPluginName());
                return lf_XfiVzHae.transform(p_YkF6TEyB, lf_f3pS4Jbm.getPluginParam());
            }
        }
        return p_YkF6TEyB;
    }
}
