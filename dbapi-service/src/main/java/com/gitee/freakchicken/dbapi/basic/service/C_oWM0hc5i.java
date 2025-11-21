package com.gitee.freakchicken.dbapi.basic.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@DS("meta-db")
public class C_oWM0hc5i {
    private static final Logger log = LoggerFactory.getLogger(C_oWM0hc5i.class);

    public Map<String, Object> m_K4T47eNY(HttpServletRequest p_1MX8Lx7A, ApiConfig p_iB09DLAh) {
        Map<String, Object> lf_Q0KqOuYb = new HashMap<>();
        JSONArray lf_jzqaZrIP = JSON.parseArray(p_iB09DLAh.getParams());
        for (int lf_pOwrYIJE = 0; lf_pOwrYIJE < lf_jzqaZrIP.size(); lf_pOwrYIJE++) {
            JSONObject lf_5b3sBcBV = lf_jzqaZrIP.getJSONObject(lf_pOwrYIJE);
            String lf_cv4cFLrv = lf_5b3sBcBV.getString("name");
            String lf_tS8vpRGh = lf_5b3sBcBV.getString("type");
            if (lf_tS8vpRGh.startsWith("Array")) {
                String[] lf_6d0hrsNL = p_1MX8Lx7A.getParameterValues(lf_cv4cFLrv);
                if (lf_6d0hrsNL != null) {
                    List<String> lf_OlMcmxsj = Arrays.asList(lf_6d0hrsNL);
                    if (lf_6d0hrsNL.length > 0) {
                        List<Double> lf_sdTGQP6k;
                        List<Long> lf_tPxgEil3;
                        switch (lf_tS8vpRGh) {
                            case "Array<double>":
                                lf_sdTGQP6k = (List<Double>)lf_OlMcmxsj.stream().map(lambda_lf_xVCaRYq6 -> Double.valueOf(lambda_lf_xVCaRYq6)).collect(Collectors.toList());
                                lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_sdTGQP6k);
                                break;
                            case "Array<bigint>":
                                lf_tPxgEil3 = (List<Long>)lf_OlMcmxsj.stream().map(lambda_lf_V48Yhy38 -> Long.valueOf(lambda_lf_V48Yhy38)).collect(Collectors.toList());
                                lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_tPxgEil3);
                                break;
                            case "Array<string>":
                            case "Array<date>":
                                lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_OlMcmxsj);
                                break;
                        }
                    } else {
                        lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_OlMcmxsj);
                    }
                } else {
                    lf_Q0KqOuYb.put(lf_cv4cFLrv, null);
                }
            } else {
                String lf_aIczjZm3 = p_1MX8Lx7A.getParameter(lf_cv4cFLrv);
                if (StringUtils.isNotBlank(lf_aIczjZm3)) {
                    Double lf_IPx5Yn8s;
                    Long lf_s5yE4GEo;
                    switch (lf_tS8vpRGh) {
                        case "double":
                            lf_IPx5Yn8s = Double.valueOf(lf_aIczjZm3);
                            lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_IPx5Yn8s);
                            break;
                        case "bigint":
                            lf_s5yE4GEo = Long.valueOf(lf_aIczjZm3);
                            lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_s5yE4GEo);
                            break;
                        case "string":
                        case "date":
                            lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_aIczjZm3);
                            break;
                    }
                } else {
                    lf_Q0KqOuYb.put(lf_cv4cFLrv, lf_aIczjZm3);
                }
            }
        }
        return lf_Q0KqOuYb;
    }
}
