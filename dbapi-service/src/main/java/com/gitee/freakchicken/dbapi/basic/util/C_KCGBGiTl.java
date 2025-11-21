package com.gitee.freakchicken.dbapi.basic.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

public class C_KCGBGiTl {
    public static void main(String[] p_rlCrXsNo) {
        System.out.println("本地IP：" + m_234JGMN5());
    }

    public static String m_234JGMN5() {
        try {
            Enumeration<NetworkInterface> lf_zU3PEtQh = NetworkInterface.getNetworkInterfaces();
            InetAddress lf_mAOkjjPR = null;
            while (lf_zU3PEtQh.hasMoreElements()) {
                NetworkInterface lf_2K4Kjif8 = lf_zU3PEtQh.nextElement();
                if (lf_2K4Kjif8.isLoopback() || lf_2K4Kjif8.isVirtual() || !lf_2K4Kjif8.isUp())
                    continue;
                Enumeration<InetAddress> lf_zSADo1FT = lf_2K4Kjif8.getInetAddresses();
                while (lf_zSADo1FT.hasMoreElements()) {
                    lf_mAOkjjPR = lf_zSADo1FT.nextElement();
                    if (lf_mAOkjjPR != null && lf_mAOkjjPR instanceof java.net.Inet4Address)
                        return lf_mAOkjjPR.getHostAddress();
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }

    public static final String m_GbDpUlpy(HttpServletRequest p_GurJXZlE) throws IOException {
        String lf_R1yRZKwj = p_GurJXZlE.getHeader("x-forwarded-for");
        if (lf_R1yRZKwj == null || lf_R1yRZKwj.length() == 0 || "unknown".equalsIgnoreCase(lf_R1yRZKwj)) {
            if (lf_R1yRZKwj == null || lf_R1yRZKwj.length() == 0 || "unknown".equalsIgnoreCase(lf_R1yRZKwj))
                lf_R1yRZKwj = p_GurJXZlE.getHeader("Proxy-Client-IP");
            if (lf_R1yRZKwj == null || lf_R1yRZKwj.length() == 0 || "unknown".equalsIgnoreCase(lf_R1yRZKwj))
                lf_R1yRZKwj = p_GurJXZlE.getHeader("WL-Proxy-Client-IP");
            if (lf_R1yRZKwj == null || lf_R1yRZKwj.length() == 0 || "unknown".equalsIgnoreCase(lf_R1yRZKwj))
                lf_R1yRZKwj = p_GurJXZlE.getHeader("HTTP_CLIENT_IP");
            if (lf_R1yRZKwj == null || lf_R1yRZKwj.length() == 0 || "unknown".equalsIgnoreCase(lf_R1yRZKwj))
                lf_R1yRZKwj = p_GurJXZlE.getHeader("HTTP_X_FORWARDED_FOR");
            if (lf_R1yRZKwj == null || lf_R1yRZKwj.length() == 0 || "unknown".equalsIgnoreCase(lf_R1yRZKwj))
                lf_R1yRZKwj = p_GurJXZlE.getRemoteAddr();
        } else if (lf_R1yRZKwj.length() > 15) {
            String[] lf_dY4heR4Y = lf_R1yRZKwj.split(",");
            for (int lf_52GimVRi = 0; lf_52GimVRi < lf_dY4heR4Y.length; lf_52GimVRi++) {
                String lf_TReAM72y = lf_dY4heR4Y[lf_52GimVRi];
                if (!"unknown".equalsIgnoreCase(lf_TReAM72y)) {
                    lf_R1yRZKwj = lf_TReAM72y;
                    break;
                }
            }
        }
        return lf_R1yRZKwj;
    }
}
