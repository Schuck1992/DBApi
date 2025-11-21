package com.dbapi;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C_4QNAxexX {
    private static Logger gf_luFJHc1p = LoggerFactory.getLogger("licenseLogger");

    private static Properties gf_N8Y9mnmM = new Properties();

    private static String gf_amFt16YO = "";

    private static String gf_0LHckN6g = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgakfsm1SbR65j0dXgxUsNVTyPd8jzoAHzL9QSoI9OlmEGeRWkc/16Qvai1X4pWFmtNsxblZgvIeaWOmsmsMh8BrxWBKHwH/tU6wIkm8ftmDgF5ttNGIcUEFT2eq98IeL/ZkU/4rerxYvxYQU3yfiAb0rViVDaOsLnFpQz6noMaQIDAQAB";

    private static String gf_cxsRriYR = "";

    private static String gf_dNHDedf1 = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIFp/Az7j6K6EIUgP0UKWV7xf7n3pg1RBZMQpNotnVcwO7ikXr0zmTupoMb9HR9lT5PvfJUeVTwRvpLA0WBjTWDaJdiEpGZBBro9dp9ddcaWmWVxmw3PdRDn5N3QEunEVGqPdN9ZC5lxaTmbp1b8q0sn9dGw7XOjODqPpekaf4d1AgMBAAECgYAhkUMOfwW/uLFmRnoCx29tAAkYTJMmqxheEBgie2hvYBRtjT0BqGubnSEV3Dt8lEOy5JCVATwsi5G58QeeD8PW99VbJpgNv2xOp/2idkd7aEa0DIauQ5uK1Cpobb1YHxa/AVv4ErVJrfPMlX7jNmiIx5RmDAByDTu253J62WNLoQJBAL8VSxPdtWOgCP6Vhx3rgEi4IhWSGbNjMI3FR/EMS96KyLyViAHBp59nrPeN5OzGNeKWE7Ke5latPzyHBtZ1EMkCQQCtYUH6IfZu+4a6QlQU7Agr50/uUGKJxIXsQl1KJiOLxxnF0OhPgznVDlO1+7T/f6cypu9ePq2fOWa2if/FDiNNAkBr3hVXzZyL9Nee/8IavcrZQjjbfHJNtfy+y1NlW8+ofSf8bV0twKhjcB9QUCWfE/VvR9Eu0EyvOXWtMXxGrCchAkBdESbkSNTKkDOqya3uqSBdyMWsK/Qo9ZfZ0WnYQo60GkToXZJGFC+4AP/IYPuwZmpukxNMaKK0JJDRDVSBB2zFAkAJvfjA++J8C307/OcXvd3SzxxP2tVEWZQH/m+M21dn8HFRcz09Tj2iAnSrB8jUY92TCgF9DpLnC84kkuFh53Y4";

    private static String gf_KsAXPr97 = "";

    static {
        InputStream lf_XPuNGTra = C_4QNAxexX.class.getClassLoader().getResourceAsStream("key.properties");
        try {
            gf_N8Y9mnmM.load(lf_XPuNGTra);
            String lf_cCdF9UjD = gf_N8Y9mnmM.getProperty("license");
            if (StringUtils.isBlank(lf_cCdF9UjD)) {
                gf_luFJHc1p.error("License absent");
                gf_luFJHc1p.info("\nSerial Number:\n" + C_ipCAYRj9.m_cnlrQ2U4() + "\n--------------------------------------------------------");
                System.exit(-1);
            }
            String[] lf_L9vdY1bq = lf_cCdF9UjD.split("\\$");
            if (lf_L9vdY1bq.length != 3) {
                gf_luFJHc1p.error("License format error");
                gf_luFJHc1p.info("\nSerial Number:\n" + C_ipCAYRj9.m_cnlrQ2U4() + "\n--------------------------------------------------------");
                System.exit(-1);
            }
            gf_amFt16YO = lf_L9vdY1bq[0];
            gf_cxsRriYR = lf_L9vdY1bq[1];
            gf_KsAXPr97 = lf_L9vdY1bq[2];
        } catch (IOException e) {
            gf_luFJHc1p.error(e.getMessage(), e);
        }
    }

    public static boolean m_EqlkeY2K(String p_tPqtraMX) {
        boolean lf_KDelxei6 = (m_2RrnogfX(p_tPqtraMX) && m_dj81GEMg() && m_gGmZUfSv(p_tPqtraMX));
        if (!lf_KDelxei6)
            System.exit(-1);
        return lf_KDelxei6;
    }

    public static boolean m_2RrnogfX(String p_qJxQw1TY) {
        String lf_0WKblhdt = null;
        try {
            lf_0WKblhdt = C_ipCAYRj9.m_cnlrQ2U4();
            boolean lf_nea666gv = C_6pJjqJio.m_uLH1xn6f(lf_0WKblhdt + "_" + p_qJxQw1TY, gf_0LHckN6g, gf_amFt16YO);
            if (!lf_nea666gv) {
                gf_luFJHc1p.error("license invalid");
                gf_luFJHc1p.info("\nSerial Number:\n" + lf_0WKblhdt + "\n--------------------------------------------------------");
            }
            return lf_nea666gv;
        } catch (Exception e) {
            gf_luFJHc1p.error("license invalid");
            gf_luFJHc1p.info("\nSerial Number:\n" + lf_0WKblhdt + "\n--------------------------------------------------------");
            return false;
        }
    }

    public static boolean m_dj81GEMg() {
        try {
            String lf_ncQyeoeI = C_6pJjqJio.m_qNprVbPJ(gf_cxsRriYR, gf_dNHDedf1);
            Date lf_NtsjpMyL = (new SimpleDateFormat("yyyyMMdd")).parse(lf_ncQyeoeI);
            if (lf_NtsjpMyL.after(new Date()))
                return true;
            gf_luFJHc1p.error("license expired");
            gf_luFJHc1p.info("\nSerial Number:\n" + C_ipCAYRj9.m_cnlrQ2U4() + "\n--------------------------------------------------------");
            return false;
        } catch (Exception e) {
            gf_luFJHc1p.error("license invalid");
            gf_luFJHc1p.info("\nSerial Number:\n" + C_ipCAYRj9.m_cnlrQ2U4() + "\n--------------------------------------------------------");
            return false;
        }
    }

    public static boolean m_gGmZUfSv(String p_RbKJCbdE) {
        String lf_R5ntKCnh = null;
        try {
            lf_R5ntKCnh = C_ipCAYRj9.m_cnlrQ2U4();
            if (C_6pJjqJio.m_uLH1xn6f(lf_R5ntKCnh + "_" + p_RbKJCbdE + "_" + C_wKjcoS0Q.gf_f7Qq16Ze, gf_0LHckN6g, gf_KsAXPr97)) {
                gf_luFJHc1p.info(C_wKjcoS0Q.gf_f7Qq16Ze);
                C_CtyAZ80Y.m_lWuR6omz(C_wKjcoS0Q.gf_f7Qq16Ze);
                return true;
            }
            if (C_6pJjqJio.m_uLH1xn6f(lf_R5ntKCnh + "_" + p_RbKJCbdE + "_" + C_wKjcoS0Q.gf_jxmFnV8T, gf_0LHckN6g, gf_KsAXPr97)) {
                gf_luFJHc1p.info(C_wKjcoS0Q.gf_jxmFnV8T);
                C_CtyAZ80Y.m_lWuR6omz(C_wKjcoS0Q.gf_jxmFnV8T);
                return true;
            }
            if (C_6pJjqJio.m_uLH1xn6f(lf_R5ntKCnh + "_" + p_RbKJCbdE + "_" + C_wKjcoS0Q.gf_Nosvdckc, gf_0LHckN6g, gf_KsAXPr97)) {
                gf_luFJHc1p.info(C_wKjcoS0Q.gf_Nosvdckc);
                C_CtyAZ80Y.m_lWuR6omz(C_wKjcoS0Q.gf_Nosvdckc);
                return true;
            }
            if (C_6pJjqJio.m_uLH1xn6f(lf_R5ntKCnh + "_" + p_RbKJCbdE + "_" + C_wKjcoS0Q.gf_KwMdbTIk, gf_0LHckN6g, gf_KsAXPr97)) {
                gf_luFJHc1p.info(C_wKjcoS0Q.gf_KwMdbTIk);
                C_CtyAZ80Y.m_lWuR6omz(C_wKjcoS0Q.gf_KwMdbTIk);
                return true;
            }
            gf_luFJHc1p.error("edition invalid");
            gf_luFJHc1p.info("\nSerial Number:\n" + lf_R5ntKCnh + "\n--------------------------------------------------------");
            return false;
        } catch (Exception e) {
            gf_luFJHc1p.error("license invalid");
            gf_luFJHc1p.info("\nSerial Number:\n" + lf_R5ntKCnh + "\n--------------------------------------------------------");
            return false;
        }
    }

    public static void main(String[] p_P5z2qmPF) {}
}
