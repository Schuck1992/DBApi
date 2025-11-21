package com.gitee.freakchicken.dbapi.basic.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.dbapi.C_CtyAZ80Y;
import com.gitee.freakchicken.dbapi.basic.dao.C_BkM00Fx0;
import com.gitee.freakchicken.dbapi.basic.dao.C_JgqFxV7d;
import com.gitee.freakchicken.dbapi.basic.dao.C_cJJYMNnf;
import com.gitee.freakchicken.dbapi.basic.dao.C_zWByMEBh;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import com.gitee.freakchicken.dbapi.common.ApiPluginConfig;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import com.gitee.freakchicken.dbapi.plugin.CachePlugin;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("meta-db")
public class C_wVYsOSU8 {
    private static final Logger log = LoggerFactory.getLogger(C_wVYsOSU8.class);

    @Autowired
    C_cJJYMNnf gf_xAclERib;

    @Autowired
    C_BkM00Fx0 gf_3sd0VEH8;

    @Autowired
    C_zWByMEBh gf_JxDJhhZA;

    @Autowired
    C_JgqFxV7d gf_BVOdJ6xG;

    @Autowired
    CacheManager gf_UskAqLYY;

    @Value("${dbapi.api.context}")
    String gf_75U2dWf1;

    @Transactional
    public ResponseDto m_EhCNIzPb(ApiConfig p_yb1wUi5b, List<ApiPluginConfig> p_RdtEa0xv) {
        int lf_96jfNSXY = this.gf_xAclERib.m_Th6aNdeJ(p_yb1wUi5b.getPath()).intValue();
        if (lf_96jfNSXY > 0)
            return ResponseDto.fail("Path has been used!");
        Integer lf_6NXIseft = this.gf_xAclERib.selectCount(null);
        if (lf_6NXIseft.intValue() >= C_CtyAZ80Y.m_WKWU3GQo().intValue())
            return ResponseDto.fail("The number of API exceeds the limit");
        if ("application/json".equals(p_yb1wUi5b.getContentType())) {
            p_yb1wUi5b.setParams("[]");
        } else if ("application/x-www-form-urlencoded".equals(p_yb1wUi5b.getContentType())) {
            p_yb1wUi5b.setJsonParam(null);
        }
        String lf_qaWbAUG7 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        p_yb1wUi5b.setCreateTime(lf_qaWbAUG7);
        p_yb1wUi5b.setUpdateTime(lf_qaWbAUG7);
        this.gf_xAclERib.insert(p_yb1wUi5b);
        p_RdtEa0xv.stream().forEach(lambda_lf_v8o3Tqv9 -> this.gf_BVOdJ6xG.insert(lambda_lf_v8o3Tqv9));
        return ResponseDto.successWithMsg("Create API success");
    }

    @Transactional
    public ResponseDto m_WhMBVUDf(ApiConfig p_2XimaOSc, List<ApiPluginConfig> p_faiY2J8R) {
        int lf_svQsb3Hz = this.gf_xAclERib.m_kdtYO3mF(p_2XimaOSc.getPath(), p_2XimaOSc.getId()).intValue();
        if (lf_svQsb3Hz > 0)
            return ResponseDto.fail("Path has been used");
        ApiConfig lf_1peNXhm3 = m_hA9ufxjj(p_2XimaOSc.getId());
        m_HBOklhDT(lf_1peNXhm3);
        if ("application/json".equals(p_2XimaOSc.getContentType())) {
            p_2XimaOSc.setParams("[]");
        } else if ("application/x-www-form-urlencoded".equals(p_2XimaOSc.getContentType())) {
            p_2XimaOSc.setJsonParam(null);
        }
        String lf_RA2T2GnM = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        p_2XimaOSc.setUpdateTime(lf_RA2T2GnM);
        this.gf_xAclERib.updateById(p_2XimaOSc);
        this.gf_BVOdJ6xG.m_m6MAeEOy(p_2XimaOSc.getId());
        p_faiY2J8R.stream().forEach(lambda_lf_Ggw6Ohn1 -> this.gf_BVOdJ6xG.insert(lambda_lf_Ggw6Ohn1));
        return ResponseDto.successWithMsg("Update API Success");
    }

    @Transactional
    public void m_RfxGuUa3(String p_kZ57McMS) {
        ApiConfig lf_cIbzz0Tj = m_hA9ufxjj(p_kZ57McMS);
        m_HBOklhDT(lf_cIbzz0Tj);
        this.gf_xAclERib.deleteById(p_kZ57McMS);
        this.gf_BVOdJ6xG.m_m6MAeEOy(p_kZ57McMS);
    }

    private void m_HBOklhDT(ApiConfig p_8i94fXVn) {
        this.gf_UskAqLYY.getCache("api").evictIfPresent(p_8i94fXVn.getPath());
        if (p_8i94fXVn.getCachePlugin() != null)
            try {
                CachePlugin lf_fTpBu1yg = PluginManager.getCachePlugin(p_8i94fXVn.getCachePlugin().getPluginName());
                lf_fTpBu1yg.clean(p_8i94fXVn, p_8i94fXVn.getCachePlugin().getPluginParam());
                log.debug("clean data cache when delete/update/offline api");
            } catch (Exception e) {
                log.error("clean cache failed when delete/update/offline api", e);
            }
    }

    public ApiConfig m_hA9ufxjj(String p_e1wE4MqK) {
        ApiConfig lf_2pfudc93 = (ApiConfig)this.gf_xAclERib.selectById(p_e1wE4MqK);
        m_Hd6LIobe(lf_2pfudc93);
        return lf_2pfudc93;
    }

    private void m_Hd6LIobe(ApiConfig p_tN7dDe2u) {
        if (p_tN7dDe2u != null) {
            p_tN7dDe2u.setTaskJson(JSON.parseArray(p_tN7dDe2u.getTask()));
            p_tN7dDe2u.setParamsJson(JSON.parseArray(p_tN7dDe2u.getParams()));
            List<ApiPluginConfig> lf_pGP68iK6 = this.gf_BVOdJ6xG.m_CFp7eRGW(p_tN7dDe2u.getId());
            p_tN7dDe2u.setAlarmPlugins(lf_pGP68iK6);
            ApiPluginConfig lf_OkRbKNTL = this.gf_BVOdJ6xG.m_o1sH5dFs(p_tN7dDe2u.getId());
            p_tN7dDe2u.setCachePlugin(lf_OkRbKNTL);
            ApiPluginConfig lf_BV48rTGq = this.gf_BVOdJ6xG.m_Ly8qqERI(p_tN7dDe2u.getId());
            p_tN7dDe2u.setGlobalTransformPlugin(lf_BV48rTGq);
        }
    }

    public List<ApiConfig> m_mDeyeayM() {
        List<ApiConfig> lf_a6IDyfVR = this.gf_xAclERib.selectList(null);
        List<ApiConfig> lf_uRXsSKh4 = (List<ApiConfig>)lf_a6IDyfVR.stream().sorted(Comparator.comparing(ApiConfig::getUpdateTime).reversed()).collect(Collectors.toList());
        return lf_uRXsSKh4;
    }

    public List<JSONObject> m_rbrlGBqs() {
        List<Group> lf_1sPKRIsk = this.gf_3sd0VEH8.selectList(null);
        List<JSONObject> lf_cUaT1Y3Y = (List<JSONObject>)lf_1sPKRIsk.stream().sorted(Comparator.comparing(Group::getUpdateTime)).map(lambda_lf_MIeqxQqE -> {
            List<ApiConfig> lf_uLGjZpwy = this.gf_xAclERib.m_cmezhiWw(lambda_lf_MIeqxQqE.getId());
            List<JSONObject> lf_nW2T5oco = (List<JSONObject>)lf_uLGjZpwy.stream().sorted(Comparator.comparing(ApiConfig::getUpdateTime)).map(()).collect(Collectors.toList());
            JSONObject lf_je5Pjq75 = new JSONObject();
            lf_je5Pjq75.put("name", lambda_lf_MIeqxQqE.getName());
            lf_je5Pjq75.put("id", lambda_lf_MIeqxQqE.getId());
            lf_je5Pjq75.put("type", "group");
            lf_je5Pjq75.put("children", lf_nW2T5oco);
            return lf_je5Pjq75;
        }).collect(Collectors.toList());
        return lf_cUaT1Y3Y;
    }

    public List<ApiConfig> m_7q7vgSUm(String p_6IiYrjTn, String p_Ew1XM2e6, String p_JAsJ3xGF, String p_6EPEP4tn) {
        if (StringUtils.isNoneBlank(new CharSequence[] { p_6IiYrjTn }))
            p_6IiYrjTn = "%" + p_6IiYrjTn + "%";
        if (StringUtils.isNoneBlank(new CharSequence[] { p_Ew1XM2e6 }))
            p_Ew1XM2e6 = "%" + p_Ew1XM2e6 + "%";
        if (StringUtils.isNoneBlank(new CharSequence[] { p_JAsJ3xGF }))
            p_JAsJ3xGF = "%" + p_JAsJ3xGF + "%";
        return this.gf_xAclERib.m_1dPnN8rP(p_6IiYrjTn, p_Ew1XM2e6, p_JAsJ3xGF, p_6EPEP4tn);
    }

    @Cacheable(value = {"api"}, key = "#path", unless = "#result == null")
    public ApiConfig m_4GNK4h5M(String path) {
        ApiConfig lf_rpxw8chA = this.gf_xAclERib.m_dVlswfHt(path);
        m_Hd6LIobe(lf_rpxw8chA);
        return lf_rpxw8chA;
    }

    public void m_GKkyTShG(String p_xWMudt2f) {
        ApiConfig lf_DjU7FQfm = (ApiConfig)this.gf_xAclERib.selectById(p_xWMudt2f);
        lf_DjU7FQfm.setStatus(Integer.valueOf(Constants.API_STATUS_ONLINE));
        this.gf_xAclERib.updateById(lf_DjU7FQfm);
    }

    public void m_5iQ9959o(String p_UVhe5opz) {
        ApiConfig lf_zZaVizbl = m_hA9ufxjj(p_UVhe5opz);
        m_HBOklhDT(lf_zZaVizbl);
        lf_zZaVizbl.setStatus(Integer.valueOf(Constants.API_STATUS_OFFLINE));
        this.gf_xAclERib.updateById(lf_zZaVizbl);
    }

    public String m_k0pggSYM(String p_XphG7tog) {
        return ((ApiConfig)this.gf_xAclERib.selectById(p_XphG7tog)).getPath();
    }

    public String m_KtvoJG28(List<String> p_1tsw9Ml7) {
        StringBuffer lf_GdKN13g0 = new StringBuffer("# \n---\n");
        List<ApiConfig> lf_jHEan6qJ = this.gf_xAclERib.selectBatchIds(p_1tsw9Ml7);
        lf_jHEan6qJ.stream().forEach(lambda_lf_kzQJXNpB -> {
            String lf_2HUIKTk7 = "## {0}\n- /{1}/{2}\n- {3}\n- Content-Type{4}\n";
            lf_GdKN13g0.append(MessageFormat.format(lf_2HUIKTk7, new Object[] { lambda_lf_kzQJXNpB.getName(), this.gf_75U2dWf1, lambda_lf_kzQJXNpB.getPath(), lambda_lf_kzQJXNpB.getNote(), lambda_lf_kzQJXNpB.getContentType() }));
            lf_GdKN13g0.append("\n- );
            if ("application/x-www-form-urlencoded".equalsIgnoreCase(lambda_lf_kzQJXNpB.getContentType())) {
                String lf_TlzfMTxB = lambda_lf_kzQJXNpB.getParams();
                JSONArray lf_6s4fs0Sh = JSON.parseArray(lf_TlzfMTxB);
                if (lf_6s4fs0Sh.size() > 0) {
                    StringBuffer lf_nXhG0l4G = new StringBuffer();
                    lf_nXhG0l4G.append("\n\n| | | |\n");
                    lf_nXhG0l4G.append("| :----: | :----: | :----: |\n");
                    for (int lf_os8jX5Q8 = 0; lf_os8jX5Q8 < lf_6s4fs0Sh.size(); lf_os8jX5Q8++) {
                        JSONObject lf_r4YfCLzx = lf_6s4fs0Sh.getJSONObject(lf_os8jX5Q8);
                        String lf_iGhz94QH = lf_r4YfCLzx.getString("name");
                        String lf_iMWChL0i = lf_r4YfCLzx.getString("type");
                        String lf_C4ZhWDdm = lf_r4YfCLzx.getString("note");
                        lf_nXhG0l4G.append(MessageFormat.format("| {0} | {1} | {2} |\n", new Object[] { lf_iGhz94QH, lf_iMWChL0i, lf_C4ZhWDdm }));
                    }
                    lf_GdKN13g0.append(lf_nXhG0l4G);
                } else {
                    lf_GdKN13g0.append("\n");
                }
            } else if ("application/json".equalsIgnoreCase(lambda_lf_kzQJXNpB.getContentType())) {
                lf_GdKN13g0.append("\n```json\n").append(lambda_lf_kzQJXNpB.getJsonParam()).append("\n```\n");
            }
            lf_GdKN13g0.append("\n---\n");
        });
        lf_GdKN13g0.append("\n+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        return lf_GdKN13g0.toString();
    }

    public JSONObject m_08bwokdh(List<String> p_raQ4XC2i) {
        List<ApiConfig> lf_dtSjtcQu = this.gf_xAclERib.selectBatchIds(p_raQ4XC2i);
        List<ApiPluginConfig> lf_xU6Ums8l = this.gf_BVOdJ6xG.m_atPN3FTm(p_raQ4XC2i);
        JSONObject lf_0x9aRluH = new JSONObject();
        lf_0x9aRluH.put("api", lf_dtSjtcQu);
        lf_0x9aRluH.put("plugins", lf_xU6Ums8l);
        return lf_0x9aRluH;
    }

    @Transactional
    public void m_CjwFJtDd(List<ApiConfig> p_Wb2ZsvYq, List<ApiPluginConfig> p_ORT74R6S) {
        p_Wb2ZsvYq.stream().forEach(lambda_lf_qYO210Vw -> {
            lambda_lf_qYO210Vw.setCreateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
            lambda_lf_qYO210Vw.setUpdateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
            lambda_lf_qYO210Vw.setStatus(Integer.valueOf(Constants.API_STATUS_OFFLINE));
            this.gf_xAclERib.insert(lambda_lf_qYO210Vw);
        });
        p_ORT74R6S.stream().forEach(lambda_lf_2ybav3EW -> this.gf_BVOdJ6xG.insert(lambda_lf_2ybav3EW));
    }

    public Integer m_AbSxaeyy() {
        return this.gf_xAclERib.selectCount(null);
    }
}
