package com.gitee.freakchicken.dbapi.basic.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C_7if65gdx implements Filter {
    private static final Logger log = LoggerFactory.getLogger(C_7if65gdx.class);

    public void init(FilterConfig p_Gqfoy5uU) throws ServletException {}

    public void doFilter(ServletRequest p_eeK0j6tt, ServletResponse p_uPYuwMqq, FilterChain p_WVsOCP1n) throws IOException, ServletException {
        log.debug("ApiHeaderFilter filter execute");
        HttpServletResponse lf_O4O22Tnw = (HttpServletResponse)p_uPYuwMqq;
        lf_O4O22Tnw.setCharacterEncoding("UTF-8");
        lf_O4O22Tnw.setContentType("application/json; charset=utf-8");
        lf_O4O22Tnw.setHeader("Access-Control-Allow-Origin", "*");
        lf_O4O22Tnw.setHeader("Access-Control-Allow-Credentials", "true");
        lf_O4O22Tnw.setHeader("Access-Control-Allow-Headers", "*");
        lf_O4O22Tnw.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        p_WVsOCP1n.doFilter(p_eeK0j6tt, p_uPYuwMqq);
    }

    public void destroy() {}
}
