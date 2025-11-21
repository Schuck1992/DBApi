package com.gitee.freakchicken.dbapi.basic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.gitee.freakchicken.dbapi.basic.dao.C_NlOEgmXf;
import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("meta-db")
public class C_K7Ac0fQF {
    @Autowired
    C_NlOEgmXf gf_DwyP5bsZ;

    public User m_MuwWb69k(String p_xk1mJABG, String p_98ePNk8f) {
        User lf_Bs2xTbc5 = this.gf_DwyP5bsZ.m_8jKQVjlp(p_xk1mJABG, DigestUtils.md5Hex(p_98ePNk8f));
        return lf_Bs2xTbc5;
    }

    public User m_hJjtIII6(Integer p_t0jAdjxZ) {
        return (User)this.gf_DwyP5bsZ.selectById(p_t0jAdjxZ);
    }

    @Transactional
    public ResponseDto m_tth2Od6P(String p_mTEyoftG, String p_SaxnCXTP, String p_jaFzLVqq) {
        User lf_cCxY5ESl = (User)this.gf_DwyP5bsZ.selectById(p_mTEyoftG);
        if (lf_cCxY5ESl != null && DigestUtils.md5Hex(p_SaxnCXTP).equals(lf_cCxY5ESl.getPassword())) {
            lf_cCxY5ESl.setPassword(DigestUtils.md5Hex(p_jaFzLVqq));
            this.gf_DwyP5bsZ.updateById(lf_cCxY5ESl);
            return ResponseDto.successWithMsg("Change password success!");
        }
        return ResponseDto.fail("Old password incorrect");
    }
}
