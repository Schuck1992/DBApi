package com.gitee.freakchicken.dbapi.basic.log;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = {"access.log.writer"}, havingValue = "kafka")
public class C_sTVUbvxO implements C_72eYelvG {
    @Autowired
    private KafkaTemplate<String, String> gf_W3Bt7IJ7;

    @Value("${access.log.kafka.topic}")
    private String gf_8SQF4jtA;

    public void write(AccessLog p_qYgF1nDK) {
        this.gf_W3Bt7IJ7.send(this.gf_8SQF4jtA, JSON.toJSONString(p_qYgF1nDK));
    }
}
