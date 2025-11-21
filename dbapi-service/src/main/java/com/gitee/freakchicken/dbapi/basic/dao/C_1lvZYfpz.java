package com.gitee.freakchicken.dbapi.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gitee.freakchicken.dbapi.basic.domain.ClientAuth;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface C_1lvZYfpz extends BaseMapper<ClientAuth> {
    @Delete({"delete from client_auth where client_id = #{clientId}"})
    void m_4h7RQonZ(String paramString);

    @Select({"select group_id from client_auth where client_id = #{clientId} "})
    List<String> m_JWCBkwsA(String paramString);

    @Delete({"delete from client_auth where group_id = #{groupId}"})
    int m_HhKeFIyW(String paramString);
}
