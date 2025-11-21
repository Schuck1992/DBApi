package com.gitee.freakchicken.dbapi.basic.service;

import com.dbapi.C_4QNAxexX;
import com.gitee.freakchicken.dbapi.basic.dao.C_KTpWsJHv;
import com.gitee.freakchicken.dbapi.basic.domain.ClientToken;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class C_HomJ3cSW {
    private static final Logger log = LoggerFactory.getLogger(C_HomJ3cSW.class);

    @Autowired
    CacheManager gf_56XUNNyH;

    @Autowired
    C_KTpWsJHv gf_ONaXC3ZL;

    @Value("${version}")
    String gf_f5v2cAZq;

    @EventListener
    public void m_jDMzkstI(ApplicationReadyEvent p_WU8kk5Jl) {
        PluginManager.loadPlugins();
        m_kOvTOFdV();
        m_N7j51Rxq();
    }

    public void m_kOvTOFdV() {
        List<ClientToken> lf_0eZ8veFi = this.gf_ONaXC3ZL.m_95rIC9Ps();
        for (ClientToken lf_Xs6ohatT : lf_0eZ8veFi) {
            this.gf_56XUNNyH.getCache(Constants.EHCACHE_TOKEN_CLIENT).putIfAbsent(lf_Xs6ohatT.getToken(), lf_Xs6ohatT);
            this.gf_56XUNNyH.getCache(Constants.EHCACHE_CLIENT_TOKEN).put(lf_Xs6ohatT.getClientId(), lf_Xs6ohatT.getToken());
        }
        log.info("load token from db to cache success");
    }

    public void m_N7j51Rxq() {
        C_4QNAxexX.m_EqlkeY2K(this.gf_f5v2cAZq);
    }
}
