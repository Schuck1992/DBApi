package com.gitee.freakchicken.dbapi.basic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dbapi.C_CtyAZ80Y;
import com.gitee.freakchicken.dbapi.basic.dao.C_1lvZYfpz;
import com.gitee.freakchicken.dbapi.basic.dao.C_BkM00Fx0;
import com.gitee.freakchicken.dbapi.basic.dao.C_cJJYMNnf;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.util.C_yBFy9Zls;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("meta-db")
public class C_8XCeckSJ {
    @Autowired
    C_BkM00Fx0 gf_fvZhHsWy;

    @Autowired
    C_cJJYMNnf gf_h8ahOjce;

    @Autowired
    C_1lvZYfpz gf_WWHtzacG;

    @Transactional
    public ResponseDto m_zBcbWsJx(Group p_Dh3U9RfH) {
        Integer lf_lQquSfoN = this.gf_fvZhHsWy.selectCount(null);
        if (lf_lQquSfoN.intValue() >= C_CtyAZ80Y.m_GPdLDm3B().intValue())
            return ResponseDto.fail("The number of groups exceeds the limit");
        p_Dh3U9RfH.setId(C_yBFy9Zls.m_VCDBHJKc());
        p_Dh3U9RfH.setCreateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        p_Dh3U9RfH.setUpdateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        this.gf_fvZhHsWy.insert(p_Dh3U9RfH);
        return ResponseDto.successWithMsg("Create Group Success");
    }

    @Transactional
    public ResponseDto m_IktpBH6U(String p_cnhIAxwZ) {
        int lf_RSdv5myv = this.gf_h8ahOjce.m_V5Oiji3m(p_cnhIAxwZ);
        if (lf_RSdv5myv > 0)
            return ResponseDto.fail("Group is not empty, can not delete");
        this.gf_fvZhHsWy.deleteById(p_cnhIAxwZ);
        this.gf_WWHtzacG.m_HhKeFIyW(p_cnhIAxwZ);
        return ResponseDto.successWithMsg("Group delete success");
    }

    public List<Group> m_qRbWAMuj() {
        return this.gf_fvZhHsWy.selectList(null);
    }

    public List<Group> m_KyQGgcHd(List<String> p_79et6He1) {
        return this.gf_fvZhHsWy.selectBatchIds(p_79et6He1);
    }

    @Transactional
    public void m_TqMvg6K2(List<Group> p_ickoXWek) {
        p_ickoXWek.stream().forEach(lambda_lf_dxuL5V90 -> this.gf_fvZhHsWy.insert(lambda_lf_dxuL5V90));
    }

    @Transactional
    public void m_IssKOSTZ(Group p_dK4MiCTj) {
        p_dK4MiCTj.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        this.gf_fvZhHsWy.updateById(p_dK4MiCTj);
    }

    public Integer m_A43AZJfD() {
        return this.gf_fvZhHsWy.selectCount(null);
    }
}
