package com.gitee.freakchicken.dbapi.basic.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_3FeAXavv;
import com.gitee.freakchicken.dbapi.basic.util.C_KCGBGiTl;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C_RjRxv4ql implements Filter {
    private static final Logger log = LoggerFactory.getLogger(C_RjRxv4ql.class);

    @Autowired
    private C_3FeAXavv gf_o53Tzdub;

    public void init(FilterConfig p_xVLgLkB8) throws ServletException {}

    public void doFilter(ServletRequest p_10KDEJ6x, ServletResponse p_qjvvUBrw, FilterChain p_WmIKyMSk) throws IOException {
        log.debug("IP filter execute");
        HttpServletRequest lf_2ltsIQvW = (HttpServletRequest)p_10KDEJ6x;
        HttpServletResponse lf_nn8Lx13x = (HttpServletResponse)p_qjvvUBrw;
        String lf_zANnuo44 = C_KCGBGiTl.m_GbDpUlpy(lf_2ltsIQvW);
        String lf_syFqjRSv = lf_2ltsIQvW.getMethod();
        PrintWriter lf_9sQtH7Ia = null;
        try {
            if (lf_syFqjRSv.equals("OPTIONS")) {
                lf_nn8Lx13x.setStatus(200);
                return;
            }
            boolean lf_2XEp5K20 = this.gf_o53Tzdub.m_uzribJzi(lf_zANnuo44);
            if (!lf_2XEp5K20) {
                lf_9sQtH7Ia = lf_nn8Lx13x.getWriter();
                lf_nn8Lx13x.setStatus(403);
                lf_9sQtH7Ia.append(JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_zANnuo44 + "), access forbidden")));
            } else {
                p_WmIKyMSk.doFilter(p_10KDEJ6x, p_qjvvUBrw);
            }
        } catch (Exception e) {
            lf_nn8Lx13x.setStatus(500);
            lf_9sQtH7Ia.append(JSON.toJSONString(ResponseDto.fail(e.toString())));
            log.error(e.toString());
        } finally {
            if (lf_9sQtH7Ia != null)
                lf_9sQtH7Ia.close();
        }
    }

    public void destroy() {}
}
