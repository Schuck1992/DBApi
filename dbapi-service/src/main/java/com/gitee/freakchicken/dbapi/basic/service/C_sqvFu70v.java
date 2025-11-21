package com.gitee.freakchicken.dbapi.basic.service;

import com.dbapi.C_4QNAxexX;
import com.dbapi.C_CtyAZ80Y;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class C_sqvFu70v {
    private static final Logger log = LoggerFactory.getLogger(C_sqvFu70v.class);

    @Autowired
    C_wVYsOSU8 gf_ibuBTf2J;

    @Autowired
    C_PPKGzyLn gf_40ZUKyBM;

    @Autowired
    C_8XCeckSJ gf_G1HpstOG;

    @Autowired
    C_TUHlgH0Q gf_PYjyGwPZ;

    @Value("${version}")
    String gf_CdjGL0rI;

    @Scheduled(cron = "0 0 0 * * ?")
    public void m_EmCdDFHA() {
        C_4QNAxexX.m_EqlkeY2K(this.gf_CdjGL0rI);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void m_YfMbt124() {
        Integer lf_hYZqXURw = this.gf_ibuBTf2J.m_AbSxaeyy();
        Integer lf_9l99zCMG = this.gf_40ZUKyBM.m_39uBLdbm();
        Integer lf_4Z7axyM6 = this.gf_G1HpstOG.m_A43AZJfD();
        Integer lf_KxW8urIW = this.gf_PYjyGwPZ.m_mbl4HGFD();
        if (lf_hYZqXURw.intValue() > C_CtyAZ80Y.m_WKWU3GQo().intValue()) {
            log.error("The number of API exceeds the limit");
            System.exit(-1);
        }
        if (lf_9l99zCMG.intValue() > C_CtyAZ80Y.m_pD9uPoml().intValue()) {
            log.error("The number of datasource exceeds the limit");
            System.exit(-1);
        }
        if (lf_4Z7axyM6.intValue() > C_CtyAZ80Y.m_GPdLDm3B().intValue()) {
            log.error("The number of groups exceeds the limit");
            System.exit(-1);
        }
        if (lf_KxW8urIW.intValue() > C_CtyAZ80Y.m_I3SOO4ki().intValue()) {
            log.error("The number of clients exceeds the limit");
            System.exit(-1);
        }
    }
}
