package com.gitee.freakchicken.dbapi.basic.log;

import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_w5RdsxjI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = {"access.log.writer"}, havingValue = "db")
public class C_DRQLnFMM implements C_72eYelvG {
    @Autowired
    private C_w5RdsxjI gf_PoEOcTIY;

    public void write(AccessLog p_HoDEoYhA) {
        this.gf_PoEOcTIY.m_xiVspeTZ(p_HoDEoYhA);
    }
}
