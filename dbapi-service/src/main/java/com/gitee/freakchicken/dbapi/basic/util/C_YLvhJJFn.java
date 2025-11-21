package com.gitee.freakchicken.dbapi.basic.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class C_YLvhJJFn {
    private static Properties gf_u7fSgfJR = new Properties();

    static {
        InputStream lf_KB8Q2g8x = C_YLvhJJFn.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            gf_u7fSgfJR.load(lf_KB8Q2g8x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String m_5QZHefoS(String p_r4az29QC) {
        return gf_u7fSgfJR.getProperty(p_r4az29QC);
    }
}
