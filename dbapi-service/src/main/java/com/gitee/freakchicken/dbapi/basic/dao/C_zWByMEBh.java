package com.gitee.freakchicken.dbapi.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface C_zWByMEBh extends BaseMapper<DataSource> {
    @Select({"select * from datasource where type = #{type}"})
    List<DataSource> m_v0Dptkwx(String paramString);
}
