package com.gitee.freakchicken.dbapi.basic.servlet;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.domain.ClientToken;
import com.gitee.freakchicken.dbapi.basic.service.C_TUHlgH0Q;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C_WUFXj6i9 extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(C_WUFXj6i9.class);

    @Autowired
    private C_TUHlgH0Q gf_rKg8ukYY;

    protected void doGet(HttpServletRequest p_GPAu8TRj, HttpServletResponse p_SjAzUWuz) {
        p_SjAzUWuz.setCharacterEncoding("UTF-8");
        p_SjAzUWuz.setContentType("application/json; charset=utf-8");
        p_SjAzUWuz.setHeader("Access-Control-Allow-Origin", "*");
        p_SjAzUWuz.setHeader("Access-Control-Allow-Credentials", "true");
        p_SjAzUWuz.setHeader("Access-Control-Allow-Headers", "*");
        p_SjAzUWuz.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        String lf_4fG0LV0B = p_GPAu8TRj.getParameter("clientId");
        String lf_0F2YUH5Z = p_GPAu8TRj.getParameter("secret");
        ClientToken lf_5sO3pKUZ = this.gf_rKg8ukYY.m_hN8yusAf(lf_4fG0LV0B, lf_0F2YUH5Z);
        PrintWriter lf_1HCF1mP3 = null;
        try {
            lf_1HCF1mP3 = p_SjAzUWuz.getWriter();
            lf_1HCF1mP3.append(JSON.toJSONString(lf_5sO3pKUZ));
        } catch (Exception e) {
            p_SjAzUWuz.setStatus(500);
            log.error(e.toString(), e);
        } finally {
            if (lf_1HCF1mP3 != null)
                lf_1HCF1mP3.close();
        }
    }

    protected void doPost(HttpServletRequest p_9WWeI9Ld, HttpServletResponse p_SBKiSX0Z) {
        doGet(p_9WWeI9Ld, p_SBKiSX0Z);
    }
}
