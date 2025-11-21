package com.gitee.freakchicken.dbapi.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gitee.freakchicken.dbapi.common.ApiPluginConfig;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface C_JgqFxV7d extends BaseMapper<ApiPluginConfig> {
    @Select({"select * from api_plugin_config where api_id = #{apiId} and plugin_type=2"})
    List<ApiPluginConfig> m_CFp7eRGW(String paramString);

    @Select({"select * from api_plugin_config where api_id = #{apiId} and plugin_type=1 "})
    ApiPluginConfig m_o1sH5dFs(String paramString);

    @Select({"select * from api_plugin_config where api_id = #{apiId} and plugin_type=3"})
    ApiPluginConfig m_Ly8qqERI(String paramString);

    @Delete({"delete from api_plugin_config where api_id = #{apiId} "})
    int m_m6MAeEOy(String paramString);

    @Select({"<script>select * from api_plugin_config where api_id in <foreach open=\"(\" close=\")\" collection=\"ids\" separator=\",\" item=\"item\" index=\"index\">#{item}</foreach></script>"})
    List<ApiPluginConfig> m_atPN3FTm(@Param("ids") List<String> paramList);
}
