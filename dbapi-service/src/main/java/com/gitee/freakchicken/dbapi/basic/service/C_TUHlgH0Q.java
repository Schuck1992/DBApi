package com.gitee.freakchicken.dbapi.basic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dbapi.C_CtyAZ80Y;
import com.gitee.freakchicken.dbapi.basic.dao.C_1lvZYfpz;
import com.gitee.freakchicken.dbapi.basic.dao.C_KTpWsJHv;
import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.domain.ClientAuth;
import com.gitee.freakchicken.dbapi.basic.domain.ClientToken;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("meta-db")
public class C_TUHlgH0Q {
    private static final Logger log = LoggerFactory.getLogger(C_TUHlgH0Q.class);

    @Autowired
    private C_KTpWsJHv gf_W7UZCxxU;

    @Autowired
    private C_1lvZYfpz gf_iBABlvxr;

    @Autowired
    CacheManager gf_ar0CsM28;

    public Integer m_mbl4HGFD() {
        return this.gf_W7UZCxxU.selectCount(null);
    }

    @Transactional
    public ResponseDto m_0nUAC9pD(Client p_8oVrS6vs) {
        Integer lf_zqE3Q664 = this.gf_W7UZCxxU.selectCount(null);
        if (lf_zqE3Q664.intValue() >= C_CtyAZ80Y.m_I3SOO4ki().intValue())
            return ResponseDto.fail("The number of clients exceeds the limit");
        p_8oVrS6vs.setId(RandomStringUtils.random(16, true, true));
        p_8oVrS6vs.setSecret(RandomStringUtils.random(32, true, true));
        if (p_8oVrS6vs.getExpireDesc().equals("5min")) {
            p_8oVrS6vs.setExpireDuration(Long.valueOf(300L));
        } else if (p_8oVrS6vs.getExpireDesc().equals("1hour")) {
            p_8oVrS6vs.setExpireDuration(Long.valueOf(3600L));
        } else if (p_8oVrS6vs.getExpireDesc().equals("1day")) {
            p_8oVrS6vs.setExpireDuration(Long.valueOf(86400L));
        } else if (p_8oVrS6vs.getExpireDesc().equals("30day")) {
            p_8oVrS6vs.setExpireDuration(Long.valueOf(2592000L));
        } else if (p_8oVrS6vs.getExpireDesc().equals("once")) {
            p_8oVrS6vs.setExpireDuration(Long.valueOf(0L));
        } else if (p_8oVrS6vs.getExpireDesc().equals("forever")) {
            p_8oVrS6vs.setExpireDuration(Long.valueOf(-1L));
        }
        p_8oVrS6vs.setCreateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        p_8oVrS6vs.setUpdateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        this.gf_W7UZCxxU.insert(p_8oVrS6vs);
        return ResponseDto.successWithData(p_8oVrS6vs);
    }

    public List<Client> m_eGgbtsUA() {
        return this.gf_W7UZCxxU.selectByMap(null);
    }

    @Transactional
    public void m_aRBx4G3s(String p_MdtH4azO) {
        this.gf_W7UZCxxU.deleteById(p_MdtH4azO);
        String lf_w99sWLOs = (String)this.gf_ar0CsM28.getCache(Constants.EHCACHE_CLIENT_TOKEN).get(p_MdtH4azO, String.class);
        if (lf_w99sWLOs != null)
            this.gf_ar0CsM28.getCache(Constants.EHCACHE_TOKEN_CLIENT).evict(lf_w99sWLOs);
        this.gf_ar0CsM28.getCache(Constants.EHCACHE_CLIENT_TOKEN).evict(p_MdtH4azO);
        this.gf_ar0CsM28.getCache(Constants.EHCACHE_CLIENT_AUTH_GROUPS).evict(p_MdtH4azO);
    }

    @Transactional
    public void m_VANk6IfD(String p_woYBEoCB, String p_EoORh097) {
        this.gf_ar0CsM28.getCache(Constants.EHCACHE_CLIENT_AUTH_GROUPS).evictIfPresent(p_woYBEoCB);
        this.gf_iBABlvxr.m_4h7RQonZ(p_woYBEoCB);
        if (StringUtils.isNoneBlank(new CharSequence[] { p_EoORh097 })) {
            String[] lf_9OvAogTU = p_EoORh097.split(",");
            Arrays.<String>stream(lf_9OvAogTU).forEach(lambda_lf_Q5Ylkhki -> {
                ClientAuth lf_0CVRavtH = new ClientAuth();
                lf_0CVRavtH.setClientId(p_woYBEoCB);
                lf_0CVRavtH.setGroupId(lambda_lf_Q5Ylkhki);
                this.gf_iBABlvxr.insert(lf_0CVRavtH);
            });
        }
    }

    @Cacheable(value = {"client_auth_groups"}, key = "#clientId", unless = "#result == null")
    public List<String> m_zd5lsvtn(String clientId) {
        List<String> lf_q9iHggD1 = this.gf_iBABlvxr.m_JWCBkwsA(clientId);
        return lf_q9iHggD1;
    }

    @Cacheable(value = {"app"}, key = "#clientId", unless = "#result == null")
    public Client m_irKj2cuo(String clientId) {
        Client lf_2KZBpmEL = (Client)this.gf_W7UZCxxU.selectById(clientId);
        return lf_2KZBpmEL;
    }

    @Transactional
    public ClientToken m_hN8yusAf(String p_XY4bVbUK, String p_Zt83yKkd) {
        Client lf_j7DaXDqa = m_irKj2cuo(p_XY4bVbUK);
        if (lf_j7DaXDqa == null)
            return null;
        if (!p_Zt83yKkd.equals(lf_j7DaXDqa.getSecret()))
            return null;
        String lf_ncwboXfu = RandomStringUtils.random(32, true, true);
        ClientToken lf_X4z67XGF = new ClientToken();
        lf_X4z67XGF.setToken(lf_ncwboXfu);
        lf_X4z67XGF.setClientId(p_XY4bVbUK);
        if (lf_j7DaXDqa.getExpireDuration().longValue() == 0L) {
            lf_X4z67XGF.setExpireAt(Long.valueOf(0L));
        } else if (lf_j7DaXDqa.getExpireDuration().longValue() == -1L) {
            lf_X4z67XGF.setExpireAt(Long.valueOf(-1L));
        } else if (lf_j7DaXDqa.getExpireDuration().longValue() > 0L) {
            long lf_XjbCAiYx = System.currentTimeMillis() + lf_j7DaXDqa.getExpireDuration().longValue() * 1000L;
            lf_X4z67XGF.setExpireAt(Long.valueOf(lf_XjbCAiYx));
        }
        if (lf_j7DaXDqa.getExpireDuration().longValue() != 0L)
            this.gf_W7UZCxxU.m_FuiMVEWD(p_XY4bVbUK, lf_X4z67XGF.getToken(), lf_X4z67XGF.getExpireAt().longValue());
        this.gf_ar0CsM28.getCache(Constants.EHCACHE_TOKEN_CLIENT).putIfAbsent(lf_ncwboXfu, lf_X4z67XGF);
        String lf_R4wdF3fJ = (String)this.gf_ar0CsM28.getCache(Constants.EHCACHE_CLIENT_TOKEN).get(p_XY4bVbUK, String.class);
        if (lf_R4wdF3fJ != null)
            this.gf_ar0CsM28.getCache(Constants.EHCACHE_TOKEN_CLIENT).evict(lf_R4wdF3fJ);
        this.gf_ar0CsM28.getCache(Constants.EHCACHE_CLIENT_TOKEN).put(p_XY4bVbUK, lf_ncwboXfu);
        return lf_X4z67XGF;
    }

    public String m_LBnY0zCs(String p_njIob9Zd) {
        if (p_njIob9Zd == null)
            return null;
        ClientToken lf_4XIkeh8i = (ClientToken)this.gf_ar0CsM28.getCache(Constants.EHCACHE_TOKEN_CLIENT).get(p_njIob9Zd, ClientToken.class);
        if (lf_4XIkeh8i == null)
            return null;
        Long lf_7U2rp0Y6 = lf_4XIkeh8i.getExpireAt();
        if (lf_7U2rp0Y6.longValue() == 0L) {
            this.gf_ar0CsM28.getCache(Constants.EHCACHE_TOKEN_CLIENT).evict(p_njIob9Zd);
            return lf_4XIkeh8i.getClientId();
        }
        if (lf_7U2rp0Y6.longValue() == -1L)
            return lf_4XIkeh8i.getClientId();
        if (lf_7U2rp0Y6.longValue() > 0L) {
            if (lf_7U2rp0Y6.longValue() > System.currentTimeMillis())
                return lf_4XIkeh8i.getClientId();
            this.gf_ar0CsM28.getCache(Constants.EHCACHE_TOKEN_CLIENT).evict(p_njIob9Zd);
            log.error("token [{}] expired!", p_njIob9Zd);
            throw new RuntimeException("token expired!");
        }
        return null;
    }
}
