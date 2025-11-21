package com.gitee.freakchicken.dbapi.basic.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.gitee.freakchicken.dbapi.basic.dao.C_WNd2vT0X;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("access-log-db")
public class C_w5RdsxjI {
    @Autowired
    private C_WNd2vT0X gf_jXYNTaYq;

    @Transactional
    public void m_xiVspeTZ(AccessLog p_7BCUVE7S) {
        this.gf_jXYNTaYq.insert(p_7BCUVE7S);
    }

    public List<AccessLog> m_TtLmmiUx() {
        return this.gf_jXYNTaYq.selectList(null);
    }

    public List<AccessLog> m_UKI1zPC3(String p_u3RZF63I, String p_UOJAoXiX, Long p_IOcOwMxq, Long p_Ka5lEXFR, Integer p_bbD1TnOu, String p_LEn6sYFg) {
        return this.gf_jXYNTaYq.m_khuuL00h(p_u3RZF63I, p_UOJAoXiX, p_IOcOwMxq, p_Ka5lEXFR, p_bbD1TnOu, p_LEn6sYFg);
    }

    public JSONArray m_rZW30PRv(long p_Tv75TIl0, long p_Np8Cscip) {
        List<String> lf_YFuuYi4k = m_O434D3Q3(Long.valueOf(p_Tv75TIl0), Long.valueOf(p_Np8Cscip));
        List<JSONObject> lf_Dpbar14W = this.gf_jXYNTaYq.m_jCbQ1vcH(p_Tv75TIl0, p_Np8Cscip);
        JSONObject lf_FNazx7bq = new JSONObject();
        lf_Dpbar14W.stream().forEach(lambda_lf_rStfZjIO -> lf_FNazx7bq.put(lambda_lf_rStfZjIO.getString("date"), lambda_lf_rStfZjIO));
        JSONArray lf_IB2W4MkC = new JSONArray();
        lf_YFuuYi4k.forEach(lambda_lf_KLnef3wK -> {
            JSONObject lf_CCinA60F = lf_FNazx7bq.getJSONObject(lambda_lf_KLnef3wK);
            if (lf_CCinA60F == null) {
                JSONObject lf_d5v88B6P = new JSONObject();
                lf_d5v88B6P.put("date", lambda_lf_KLnef3wK);
                lf_d5v88B6P.put("successNum", Integer.valueOf(0));
                lf_d5v88B6P.put("failNum", Integer.valueOf(0));
                lf_IB2W4MkC.add(lf_d5v88B6P);
            } else {
                lf_IB2W4MkC.add(lf_CCinA60F);
            }
        });
        return lf_IB2W4MkC;
    }

    public List<JSONObject> m_JLD8tUBT(long p_4vMXX4tr, long p_kW6wJYNd) {
        return this.gf_jXYNTaYq.m_FHwgotGo(p_4vMXX4tr, p_kW6wJYNd);
    }

    public List<JSONObject> m_yUThf9Fs(long p_vxDiSw9F, long p_8LuXjBJR) {
        return this.gf_jXYNTaYq.m_EzwOXVfB(p_vxDiSw9F, p_8LuXjBJR);
    }

    public List<JSONObject> m_ypkFPTDt(long p_iRI70DFs, long p_Slkek8ea) {
        return this.gf_jXYNTaYq.m_SDLfXASg(p_iRI70DFs, p_Slkek8ea);
    }

    public List<JSONObject> m_Muq3dFOG(long p_sS6wdnkb, long p_c71N3zgJ) {
        return this.gf_jXYNTaYq.m_Y9Kr3Mxt(p_sS6wdnkb, p_c71N3zgJ);
    }

    public JSONObject m_nYqEddIx(long p_bSjBYkbp, long p_vIcZdRgc) {
        return this.gf_jXYNTaYq.m_qVn0L6sq(p_bSjBYkbp, p_vIcZdRgc);
    }

    public List<String> m_O434D3Q3(Long p_X3LW6yn9, Long p_BaQQ5BkS) {
        SimpleDateFormat lf_6fpTY2kn = new SimpleDateFormat("YYYY-MM-dd");
        long lf_QXGkkPlu = 86400L;
        List<String> lf_eFSr8vZs = new ArrayList<>();
        long lf_WTYKWsAC;
        for (lf_WTYKWsAC = p_X3LW6yn9.longValue(); lf_WTYKWsAC <= p_BaQQ5BkS.longValue(); lf_WTYKWsAC += lf_QXGkkPlu)
            lf_eFSr8vZs.add(lf_6fpTY2kn.format(new Date(lf_WTYKWsAC * 1000L)));
        return lf_eFSr8vZs;
    }
}
