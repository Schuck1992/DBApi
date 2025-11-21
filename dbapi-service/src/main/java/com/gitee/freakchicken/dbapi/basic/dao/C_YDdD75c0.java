package com.gitee.freakchicken.dbapi.basic.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface C_YDdD75c0 {
    @Update({"update firewall set status = 'off' "})
    void m_u6OZ85BX();

    @Update({"update firewall set status = 'on' , mode = #{mode}"})
    void m_78ESXRKl(String paramString);

    @Update({"update ip_rules set ip = #{ip} where type = #{type}"})
    void m_8iaQWrKJ(@Param("ip") String paramString1, @Param("type") String paramString2);

    @Select({"select status, mode from firewall"})
    Map<String, String> m_Ni0DSGAO();

    @Select({"select type, ip from ip_rules"})
    List<Map<String, String>> m_Q3hmfdFd();

    @Select({"select ip from ip_rules where type = 'white' "})
    String m_6N5gW8kU();

    @Select({"select ip from ip_rules where type = 'black' "})
    String m_Vasjh8Ae();
}
