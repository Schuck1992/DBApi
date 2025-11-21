package com.gitee.freakchicken.dbapi.basic.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.log.C_72eYelvG;
import com.gitee.freakchicken.dbapi.basic.service.C_TUHlgH0Q;
import com.gitee.freakchicken.dbapi.basic.service.C_wVYsOSU8;
import com.gitee.freakchicken.dbapi.basic.util.C_GEUoaMz4;
import com.gitee.freakchicken.dbapi.basic.util.C_KCGBGiTl;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class C_eMKjcoVp implements Filter {
    private static final Logger log = LoggerFactory.getLogger(C_eMKjcoVp.class);

    private static Logger gf_N1uVhBZW = LoggerFactory.getLogger("accessLogger");

    @Autowired
    private C_wVYsOSU8 gf_J4FRHS0u;

    @Autowired
    private C_TUHlgH0Q gf_BRPp8aCB;

    @Autowired
    C_TUHlgH0Q gf_2rdheBiw;

    @Autowired
    C_72eYelvG gf_GWbL9f6j;

    @Value("${dbapi.api.context}")
    private String gf_Er6JhaSw;

    @Value("${access.log.writer}")
    private String gf_04k0C7WU;

    public void init(FilterConfig p_Gt347zrP) throws ServletException {}

    public void doFilter(ServletRequest p_2tI7zbN3, ServletResponse p_g5QUoWxU, FilterChain p_25IJ5LVN) throws IOException {
        long lf_LN4AymRu = System.currentTimeMillis();
        final AccessLog lf_7VRB9D1k = new AccessLog();
        lf_7VRB9D1k.setTimestamp(lf_LN4AymRu / 1000L);
        log.debug("auth filter execute");
        HttpServletRequest lf_erXDyHc7 = (HttpServletRequest)p_2tI7zbN3;
        HttpServletResponse lf_lSSgJmp2 = (HttpServletResponse)p_g5QUoWxU;
        String lf_xqOhoIWd = lf_erXDyHc7.getRequestURI();
        String lf_Il0Q4nKp = lf_xqOhoIWd.substring(this.gf_Er6JhaSw.length() + 2);
        try {
            ApiConfig lf_Fo5X2x9s = this.gf_J4FRHS0u.m_4GNK4h5M(lf_Il0Q4nKp);
            if (lf_Fo5X2x9s == null) {
                lf_lSSgJmp2.setStatus(404);
                lf_lSSgJmp2.getWriter().append(JSON.toJSONString(ResponseDto.fail("Api not exists")));
                return;
            }
            lf_7VRB9D1k.setApiId(lf_Fo5X2x9s.getId());
            String lf_1hDB1AtW = lf_erXDyHc7.getHeader("Authorization");
            String lf_WGGtKZ9f = this.gf_BRPp8aCB.m_LBnY0zCs(lf_1hDB1AtW);
            lf_7VRB9D1k.setClientId(lf_WGGtKZ9f);
            if (lf_Fo5X2x9s.getAccess().intValue() == Constants.API_ACCESS_PRIVATE) {
                if (StringUtils.isBlank(lf_1hDB1AtW)) {
                    lf_lSSgJmp2.setStatus(401);
                    lf_lSSgJmp2.getWriter().append(JSON.toJSONString(ResponseDto.fail("No Token!")));
                    return;
                }
                if (lf_WGGtKZ9f == null) {
                    log.error("token[{}] matched no clientId", lf_1hDB1AtW);
                    lf_lSSgJmp2.setStatus(401);
                    lf_lSSgJmp2.getWriter().append(JSON.toJSONString(ResponseDto.fail("Token Invalid!")));
                    return;
                }
                List<String> lf_1FDmzx1r = this.gf_2rdheBiw.m_zd5lsvtn(lf_WGGtKZ9f);
                if (!lf_1FDmzx1r.contains(lf_Fo5X2x9s.getGroupId())) {
                    log.error("token[{}] matched clientId[{}], but clientId not authorized", lf_1hDB1AtW, lf_WGGtKZ9f);
                    lf_lSSgJmp2.setStatus(401);
                    lf_lSSgJmp2.getWriter().append(JSON.toJSONString(ResponseDto.fail("Token Invalid!")));
                    return;
                }
            }
            p_25IJ5LVN.doFilter(p_2tI7zbN3, p_g5QUoWxU);
        } catch (Exception e) {
            lf_lSSgJmp2.setStatus(500);
            lf_lSSgJmp2.getWriter().append(JSON.toJSONString(ResponseDto.fail(e.toString())));
            log.error(e.getMessage(), e);
            lf_7VRB9D1k.setError(e.getMessage());
        } finally {
            if (lf_lSSgJmp2.getWriter() != null)
                lf_lSSgJmp2.getWriter().close();
            lf_7VRB9D1k.setDuration(System.currentTimeMillis() - lf_LN4AymRu);
            lf_7VRB9D1k.setIp(C_KCGBGiTl.m_GbDpUlpy(lf_erXDyHc7));
            lf_7VRB9D1k.setStatus(lf_lSSgJmp2.getStatus());
            lf_7VRB9D1k.setUrl(lf_xqOhoIWd);
            lf_7VRB9D1k.setId(UUID.randomUUID().toString());
            gf_N1uVhBZW.info(JSON.toJSONString(lf_7VRB9D1k));
            if (!this.gf_04k0C7WU.equals("null"))
                C_GEUoaMz4.m_TF0xFtGb(new Runnable() {
                    public void run() {
                        C_eMKjcoVp.this.gf_GWbL9f6j.write(lf_7VRB9D1k);
                    }
                });
        }
    }

    public void destroy() {}
}
