package com.gitee.freakchicken.dbapi.basic.util;

import org.apache.commons.codec.binary.Base64;

public class C_remwVx8I {
    private static final String gf_XXAljv56 = "UTF-8";

    public static void main(String[] p_vjoXWGwz) {
        String lf_FmCEgSBq = "root123456";
        try {
            String lf_5HZpsfEK = Base64.encodeBase64String(lf_FmCEgSBq.getBytes("UTF-8"));
            System.out.println(lf_5HZpsfEK);
            byte[] lf_udhcR0Ld = Base64.decodeBase64(lf_5HZpsfEK);
            String lf_QZOQiy0S = new String(lf_udhcR0Ld, "UTF-8");
            System.out.println(lf_QZOQiy0S);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String m_HhDnG628(String p_CjCAKadN) throws Exception {
        return Base64.encodeBase64String(p_CjCAKadN.getBytes("UTF-8"));
    }

    public static String m_9W4gMncX(String p_JWEfpDkV) throws Exception {
        if (p_JWEfpDkV == null)
            return null;
        byte[] lf_cSb1uxEP = Base64.decodeBase64(p_JWEfpDkV);
        return new String(lf_cSb1uxEP, "UTF-8");
    }
}
