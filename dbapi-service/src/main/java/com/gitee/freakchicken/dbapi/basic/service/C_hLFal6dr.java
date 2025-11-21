package com.gitee.freakchicken.dbapi.basic.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class C_hLFal6dr {
    private static final Logger log = LoggerFactory.getLogger(C_hLFal6dr.class);

    @Value("${dbapi.cluster.gateway.name}")
    String gf_VNt7fpdi;

    @Autowired
    DiscoveryClient gf_of8aCOCl;

    public String m_rzfrSdMn() {
        String lf_fj16AERb = null;
        List<ServiceInstance> lf_zHvdSepU = this.gf_of8aCOCl.getInstances(this.gf_VNt7fpdi);
        lf_fj16AERb = ((ServiceInstance)lf_zHvdSepU.get(0)).getHost() + ":" + ((ServiceInstance)lf_zHvdSepU.get(0)).getPort();
        return lf_fj16AERb;
    }
}
