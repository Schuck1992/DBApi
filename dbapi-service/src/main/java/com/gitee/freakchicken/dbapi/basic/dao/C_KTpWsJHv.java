package com.gitee.freakchicken.dbapi.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.domain.ClientToken;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface C_KTpWsJHv extends BaseMapper<Client> {
    @Select({"select * from client where id = #{id} and secret = #{secret} "})
    Client m_xbDfivMB(@Param("id") String paramString1, @Param("secret") String paramString2);

    @Select({"select * from client where token = #{token}"})
    Client m_YsLSTQGw(String paramString);

    @Update({"update client set token = #{token},expire_at = #{expireAt} where id = #{id} "})
    int m_FuiMVEWD(@Param("id") String paramString1, @Param("token") String paramString2, @Param("expireAt") long paramLong);

    @Select({"select id client_id,token,expire_at from client where token is not null"})
    List<ClientToken> m_95rIC9Ps();
}
