package com.gitee.freakchicken.dbapi.basic.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.dbapi.C_CtyAZ80Y;
import com.gitee.freakchicken.dbapi.basic.dao.C_cJJYMNnf;
import com.gitee.freakchicken.dbapi.basic.dao.C_zWByMEBh;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_khZIipIa;
import com.gitee.freakchicken.dbapi.basic.util.C_yBFy9Zls;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("meta-db")
public class C_PPKGzyLn {
    private static final Logger log = LoggerFactory.getLogger(C_PPKGzyLn.class);

    @Autowired
    CacheManager gf_oX6oSwaL;

    @Autowired
    C_zWByMEBh gf_xdfrAfgN;

    @Autowired
    C_cJJYMNnf gf_WhGIZ733;

    public Integer m_39uBLdbm() {
        return this.gf_xdfrAfgN.selectCount(null);
    }

    @Transactional
    public ResponseDto m_QVL746zo(DataSource p_X7UpW8p4) {
        Integer lf_ZIZvOOxr = this.gf_xdfrAfgN.selectCount(null);
        if (lf_ZIZvOOxr.intValue() >= C_CtyAZ80Y.m_pD9uPoml().intValue())
            return ResponseDto.fail("The number of datasources exceeds the limit");
        p_X7UpW8p4.setId(C_yBFy9Zls.m_VCDBHJKc());
        p_X7UpW8p4.setUpdateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        p_X7UpW8p4.setCreateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        this.gf_xdfrAfgN.insert(p_X7UpW8p4);
        return ResponseDto.successWithMsg("Create DataSource Success");
    }

    @Transactional
    public void m_Vff0hr2a(DataSource p_yursxJfD) {
        p_yursxJfD.setUpdateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        this.gf_xdfrAfgN.updateById(p_yursxJfD);
        if (p_yursxJfD.isJdbcType())
            C_khZIipIa.m_yNMei4Mn(p_yursxJfD.getId());
        this.gf_oX6oSwaL.getCache("datasource").evictIfPresent(p_yursxJfD.getId());
    }

    @Transactional
    public ResponseDto m_jJHgNzYS(String p_L77TfJ2X) {
        List<ApiConfig> lf_A9phBSTP = this.gf_WhGIZ733.selectList(null);
        List<String> lf_1KHHF9j4 = (List<String>)lf_A9phBSTP.stream().filter(lambda_lf_td2srrgd -> {
            String lf_m6mmmBPy = lambda_lf_td2srrgd.getTask();
            JSONArray lf_B4i37dAL = JSON.parseArray(lf_m6mmmBPy);
            for (int lf_AmVkH4iC = 0; lf_AmVkH4iC < lf_B4i37dAL.size(); lf_AmVkH4iC++) {
                JSONObject lf_chNfeEhv = lf_B4i37dAL.getJSONObject(lf_AmVkH4iC);
                String lf_JtDMIsOp = lf_chNfeEhv.getString("datasourceId");
                if (p_L77TfJ2X.equals(lf_JtDMIsOp))
                    return true;
            }
            return false;
        }).map(lambda_lf_oi7ZPUv1 -> lambda_lf_oi7ZPUv1.getName() + "(" + lambda_lf_oi7ZPUv1.getId() + ")").collect(Collectors.toList());
        if (lf_1KHHF9j4.size() == 0) {
            this.gf_xdfrAfgN.deleteById(p_L77TfJ2X);
            C_khZIipIa.m_yNMei4Mn(p_L77TfJ2X);
            this.gf_oX6oSwaL.getCache("datasource").evictIfPresent(p_L77TfJ2X);
            return ResponseDto.successWithMsg("Datasource delete success");
        }
        return ResponseDto.fail("Can not delete! Used by API: " + (String)lf_1KHHF9j4.stream().collect(Collectors.joining(";")));
    }

    @Cacheable(value = {"datasource"}, key = "#id", unless = "#result == null")
    public DataSource m_ggRKn4xy(String id) {
        DataSource lf_8ZaP1xrH = (DataSource)this.gf_xdfrAfgN.selectById(id);
        return lf_8ZaP1xrH;
    }

    public List<DataSource> m_q9gY0qn0() {
        List<DataSource> lf_K4RB1Mkh = this.gf_xdfrAfgN.selectList(null);
        List<DataSource> lf_CMzKwFLt = (List<DataSource>)lf_K4RB1Mkh.stream().sorted(Comparator.comparing(DataSource::getUpdateTime).reversed()).collect(Collectors.toList());
        return lf_CMzKwFLt;
    }

    public List<DataSource> m_ryeIemAd(List<String> p_VPC0LLEe) {
        List<DataSource> lf_H1evWkTV = this.gf_xdfrAfgN.selectBatchIds(p_VPC0LLEe);
        return lf_H1evWkTV;
    }

    @Transactional
    public void m_1Sk40boM(List<DataSource> p_2xUCRyr1) {
        p_2xUCRyr1.forEach(lambda_lf_rnAUTW7E -> {
            lambda_lf_rnAUTW7E.setUpdateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
            this.gf_xdfrAfgN.insert(lambda_lf_rnAUTW7E);
        });
    }

    public List<DataSource> m_aOcJpVCM(String p_ZiHMuP3I) {
        return this.gf_xdfrAfgN.m_v0Dptkwx(p_ZiHMuP3I);
    }
}
