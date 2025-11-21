package com.gitee.freakchicken.dbapi.basic.log;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.dao.C_WNd2vT0X;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import java.util.Collections;
import java.util.Properties;
import javax.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@MapperScan({"com.gitee.freakchicken.dbapi.basic.dao"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class C_A57l7Px6 {
    private static String gf_uJbcxoAi;

    @Autowired
    C_WNd2vT0X gf_q1Kn1rIX;

    @Value("${access.log.kafka.topic}")
    String gf_hTInFBPT;

    @Value("${spring.kafka.bootstrap-servers}")
    String gf_QojiiIM5;

    public static void main(String[] p_ydvN8REB) {
        gf_uJbcxoAi = p_ydvN8REB[0];
        (new SpringApplicationBuilder(new Class[] { C_A57l7Px6.class })).web(WebApplicationType.NONE).bannerMode(Banner.Mode.OFF).run(p_ydvN8REB);
    }

    @PostConstruct
    public void m_zfRamgtf() {
        Properties lf_UtidDAQH = new Properties();
        lf_UtidDAQH.put("bootstrap.servers", this.gf_QojiiIM5);
        lf_UtidDAQH.put("enable.auto.commit", Boolean.valueOf(true));
        lf_UtidDAQH.put("auto.commit.interval.ms", "1000");
        lf_UtidDAQH.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        lf_UtidDAQH.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        lf_UtidDAQH.put("group.id", gf_uJbcxoAi);
        lf_UtidDAQH.put("auto.offset.reset", "earliest");
        KafkaConsumer<String, String> lf_U4WbeyrQ = new KafkaConsumer(lf_UtidDAQH);
        lf_U4WbeyrQ.subscribe(Collections.singletonList(this.gf_hTInFBPT));
        while (true) {
            ConsumerRecords<String, String> lf_thrjG9xg = lf_U4WbeyrQ.poll(100L);
            for (ConsumerRecord lf_29ta4oLQ : lf_thrjG9xg) {
                AccessLog lf_lA8sodOU = (AccessLog)JSON.parseObject(lf_29ta4oLQ.value().toString(), AccessLog.class);
                this.gf_q1Kn1rIX.insert(lf_lA8sodOU);
            }
        }
    }
}
