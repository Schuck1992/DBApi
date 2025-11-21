package com.gitee.freakchicken.dbapi.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gitee.freakchicken.dbapi.basic.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface C_NlOEgmXf extends BaseMapper<User> {
    @Select({"select * from user where username = #{username} and password = #{password}"})
    User m_8jKQVjlp(@Param("username") String paramString1, @Param("password") String paramString2);
}
