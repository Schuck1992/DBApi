package com.gitee.freakchicken.dbapi.basic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.gitee.freakchicken.dbapi.basic.dao.C_YDdD75c0;
import com.gitee.freakchicken.dbapi.basic.util.IPRuleCache;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("meta-db")
public class C_3FeAXavv {
    private static final Logger log = LoggerFactory.getLogger(C_3FeAXavv.class);

    @Autowired
    private C_YDdD75c0 gf_VupNbIyw;

    public void m_Co9SCYDl(String p_KP32MF7z, String p_YNEHE0vY) {
        m_9Lct3lll(p_KP32MF7z, p_YNEHE0vY);
        m_j3xuhebc();
    }

    @Transactional
    public void m_9Lct3lll(String p_DNthuubo, String p_KHaM3GUg) {
        this.gf_VupNbIyw.m_78ESXRKl(p_DNthuubo);
        this.gf_VupNbIyw.m_8iaQWrKJ(p_KHaM3GUg, p_DNthuubo);
    }

    public void m_ex6VwI2F() {
        m_12Oxw1vN();
        m_j3xuhebc();
    }

    @Transactional
    public void m_12Oxw1vN() {
        this.gf_VupNbIyw.m_u6OZ85BX();
    }

    @PostConstruct
    public void m_j3xuhebc() {
        log.info("init ip service...");
        String lf_TcY6YJRI = this.gf_VupNbIyw.m_Vasjh8Ae();
        String lf_5w21mSf9 = this.gf_VupNbIyw.m_6N5gW8kU();
        if (StringUtils.isNoneBlank(new CharSequence[] { lf_TcY6YJRI })) {
            IPRuleCache.blackIPSet = (Set)Arrays.<String>asList(lf_TcY6YJRI.split("\n")).stream().map(lambda_lf_O1FtCAS4 -> lambda_lf_O1FtCAS4.trim()).filter(lambda_lf_fgSrY9hy -> StringUtils.isNoneBlank(new CharSequence[] { lambda_lf_fgSrY9hy })).collect(Collectors.toSet());
        } else {
            IPRuleCache.blackIPSet = new HashSet();
        }
        if (StringUtils.isNoneBlank(new CharSequence[] { lf_5w21mSf9 })) {
            IPRuleCache.whiteIPSet = (Set)Arrays.<String>asList(lf_5w21mSf9.split("\n")).stream().map(lambda_lf_sYHCgxjE -> lambda_lf_sYHCgxjE.trim()).filter(lambda_lf_zaf60qej -> StringUtils.isNoneBlank(new CharSequence[] { lambda_lf_zaf60qej })).collect(Collectors.toSet());
        } else {
            IPRuleCache.whiteIPSet = new HashSet();
        }
        Map<String, String> lf_QgbDCoZK = this.gf_VupNbIyw.m_Ni0DSGAO();
        IPRuleCache.mode = lf_QgbDCoZK.get("mode");
        IPRuleCache.status = lf_QgbDCoZK.get("status");
    }

    public Map<String, String> m_l9iyX9RU() {
        List<Map<String, String>> lf_qUr9IfRX = this.gf_VupNbIyw.m_Q3hmfdFd();
        Map<String, String> lf_rlSSPMkF = this.gf_VupNbIyw.m_Ni0DSGAO();
        lf_qUr9IfRX.stream().forEach(lambda_lf_ufRNzXx7 -> {
            String lf_S1wlmTmY = (String)lambda_lf_ufRNzXx7.get("type");
            String lf_NJiris7q = (String)lambda_lf_ufRNzXx7.get("ip");
            if (lf_S1wlmTmY.equals("white")) {
                lf_rlSSPMkF.put("whiteIP", lf_NJiris7q);
            } else if (lf_S1wlmTmY.equals("black")) {
                lf_rlSSPMkF.put("blackIP", lf_NJiris7q);
            }
        });
        return lf_rlSSPMkF;
    }

    public boolean m_uzribJzi(String p_UVnq6H4E) {
        if (IPRuleCache.status.equals("on")) {
            if (IPRuleCache.mode.equals("black")) {
                if (IPRuleCache.blackIPSet.contains(p_UVnq6H4E))
                    return false;
                return true;
            }
            if (IPRuleCache.mode.equals("white")) {
                if (IPRuleCache.whiteIPSet.contains(p_UVnq6H4E))
                    return true;
                return false;
            }
        }
        return true;
    }
}
