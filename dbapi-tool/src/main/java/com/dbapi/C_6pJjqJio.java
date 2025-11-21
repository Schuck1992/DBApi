package com.dbapi;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

public class C_6pJjqJio {
    private static final int gf_FgkJytn2 = 117;

    private static final int gf_enPbF4oP = 128;

    public static KeyPair m_8zJ0Hk06() throws Exception {
        KeyPairGenerator lf_dZePOkzd = KeyPairGenerator.getInstance("RSA");
        lf_dZePOkzd.initialize(1024);
        return lf_dZePOkzd.generateKeyPair();
    }

    public static PrivateKey m_TiXHQlYm(String p_xauj0XsJ) throws Exception {
        KeyFactory lf_bwFgGcY1 = KeyFactory.getInstance("RSA");
        byte[] lf_9C4omF1a = Base64.decodeBase64(p_xauj0XsJ.getBytes());
        PKCS8EncodedKeySpec lf_lQtStyZM = new PKCS8EncodedKeySpec(lf_9C4omF1a);
        return lf_bwFgGcY1.generatePrivate(lf_lQtStyZM);
    }

    public static PublicKey m_mSF06MKZ(String p_cqdGJHd3) throws Exception {
        KeyFactory lf_jChXfx7M = KeyFactory.getInstance("RSA");
        byte[] lf_FTq3SXqz = Base64.decodeBase64(p_cqdGJHd3.getBytes());
        X509EncodedKeySpec lf_UGLkdW60 = new X509EncodedKeySpec(lf_FTq3SXqz);
        return lf_jChXfx7M.generatePublic(lf_UGLkdW60);
    }

    public static String m_AXwaLjqO(String p_kn4sn9Ls, String p_wqznUowy) throws Exception {
        return m_ECyp3weX(p_kn4sn9Ls, m_mSF06MKZ(p_wqznUowy));
    }

    private static String m_ECyp3weX(String p_85SM8S1q, PublicKey p_rUEHflSM) throws Exception {
        Cipher lf_aknk64eG = Cipher.getInstance("RSA");
        lf_aknk64eG.init(1, p_rUEHflSM);
        int lf_QkIyzlqQ = (p_85SM8S1q.getBytes()).length;
        ByteArrayOutputStream lf_qDjMvSM3 = new ByteArrayOutputStream();
        int lf_ftP4y4OK = 0;
        int lf_4neOiayu = 0;
        while (lf_QkIyzlqQ - lf_ftP4y4OK > 0) {
            byte[] lf_GHymq2tF;
            if (lf_QkIyzlqQ - lf_ftP4y4OK > 117) {
                lf_GHymq2tF = lf_aknk64eG.doFinal(p_85SM8S1q.getBytes(), lf_ftP4y4OK, 117);
            } else {
                lf_GHymq2tF = lf_aknk64eG.doFinal(p_85SM8S1q.getBytes(), lf_ftP4y4OK, lf_QkIyzlqQ - lf_ftP4y4OK);
            }
            lf_qDjMvSM3.write(lf_GHymq2tF, 0, lf_GHymq2tF.length);
            lf_4neOiayu++;
            lf_ftP4y4OK = lf_4neOiayu * 117;
        }
        byte[] lf_9xP5Ydnt = lf_qDjMvSM3.toByteArray();
        lf_qDjMvSM3.close();
        return new String(Base64.encodeBase64String(lf_9xP5Ydnt));
    }

    public static String m_qNprVbPJ(String p_KKtZwUrc, String p_D7xC4UmH) throws Exception {
        return m_pn5zTGi7(p_KKtZwUrc, m_TiXHQlYm(p_D7xC4UmH));
    }

    private static String m_pn5zTGi7(String p_L9HAKEjN, PrivateKey p_7VfK12jV) throws Exception {
        Cipher lf_HXP9zcNj = Cipher.getInstance("RSA");
        lf_HXP9zcNj.init(2, p_7VfK12jV);
        byte[] lf_3viIKmzx = Base64.decodeBase64(p_L9HAKEjN);
        int lf_niNqR1WP = lf_3viIKmzx.length;
        ByteArrayOutputStream lf_dSrQ840U = new ByteArrayOutputStream();
        int lf_x3NFtkq0 = 0;
        int lf_qzuPBfQB = 0;
        while (lf_niNqR1WP - lf_x3NFtkq0 > 0) {
            byte[] lf_HxzpXQIY;
            if (lf_niNqR1WP - lf_x3NFtkq0 > 128) {
                lf_HxzpXQIY = lf_HXP9zcNj.doFinal(lf_3viIKmzx, lf_x3NFtkq0, 128);
            } else {
                lf_HxzpXQIY = lf_HXP9zcNj.doFinal(lf_3viIKmzx, lf_x3NFtkq0, lf_niNqR1WP - lf_x3NFtkq0);
            }
            lf_dSrQ840U.write(lf_HxzpXQIY, 0, lf_HxzpXQIY.length);
            lf_qzuPBfQB++;
            lf_x3NFtkq0 = lf_qzuPBfQB * 128;
        }
        byte[] lf_Y9tNQnVw = lf_dSrQ840U.toByteArray();
        lf_dSrQ840U.close();
        return new String(lf_Y9tNQnVw, "UTF-8");
    }

    public static String m_Z3Gvbedp(String p_sWrIWGaH, PrivateKey p_IgQ0gfbA) throws Exception {
        byte[] lf_EuEsBkOy = p_IgQ0gfbA.getEncoded();
        PKCS8EncodedKeySpec lf_UEIExrZQ = new PKCS8EncodedKeySpec(lf_EuEsBkOy);
        KeyFactory lf_1bjQYaOv = KeyFactory.getInstance("RSA");
        PrivateKey lf_lFv5Ul4T = lf_1bjQYaOv.generatePrivate(lf_UEIExrZQ);
        Signature lf_LYLV26Re = Signature.getInstance("MD5withRSA");
        lf_LYLV26Re.initSign(lf_lFv5Ul4T);
        lf_LYLV26Re.update(p_sWrIWGaH.getBytes());
        return new String(Base64.encodeBase64(lf_LYLV26Re.sign()));
    }

    public static boolean m_rZciypRd(String p_8e8rteMI, PublicKey p_701tWxB1, String p_VJgOSUI1) throws Exception {
        byte[] lf_3WB0mGLD = p_701tWxB1.getEncoded();
        X509EncodedKeySpec lf_6z3lJoQm = new X509EncodedKeySpec(lf_3WB0mGLD);
        KeyFactory lf_iZgxImfx = KeyFactory.getInstance("RSA");
        PublicKey lf_f4b2ZkTq = lf_iZgxImfx.generatePublic(lf_6z3lJoQm);
        Signature lf_Umi34rvK = Signature.getInstance("MD5withRSA");
        lf_Umi34rvK.initVerify(lf_f4b2ZkTq);
        lf_Umi34rvK.update(p_8e8rteMI.getBytes());
        return lf_Umi34rvK.verify(Base64.decodeBase64(p_VJgOSUI1.getBytes()));
    }

    public static boolean m_uLH1xn6f(String p_PuIKiFaW, String p_dveEuhJt, String p_zzsC96Td) throws Exception {
        return m_rZciypRd(p_PuIKiFaW, m_mSF06MKZ(p_dveEuhJt), p_zzsC96Td);
    }

    public static Map<String, String> m_ldHyTtlO() throws Exception {
        KeyPair lf_bJEvCZHI = m_8zJ0Hk06();
        RSAPrivateKey lf_Ruz5srXX = (RSAPrivateKey)lf_bJEvCZHI.getPrivate();
        RSAPublicKey lf_YE2IaNLz = (RSAPublicKey)lf_bJEvCZHI.getPublic();
        String lf_nrJE3Es9 = new String(Base64.encodeBase64(lf_YE2IaNLz.getEncoded()));
        String lf_XLneUX2T = new String(Base64.encodeBase64(lf_Ruz5srXX.getEncoded()));
        Map<String, String> lf_EhI7oQEL = new HashMap<>();
        lf_EhI7oQEL.put("private", lf_XLneUX2T);
        lf_EhI7oQEL.put("public", lf_nrJE3Es9);
        return lf_EhI7oQEL;
    }

    public static void main(String[] p_wz2jyG67) {}
}
