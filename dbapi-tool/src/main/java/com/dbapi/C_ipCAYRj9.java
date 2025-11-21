package com.dbapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class C_ipCAYRj9 {
    private static final String gf_JI2m8j5d = "windows";

    private static final String gf_d6EOnJZs = "linux";

    private static final String gf_ltH66ccu = "unix";

    private static final String gf_HUxOTYUv = "\\b\\w+:\\w+:\\w+:\\w+:\\w+:\\w+\\b";

    private static String m_ZZl56gPh() {
        String lf_NKoJJoYM = "";
        try {
            File lf_RpDrAHoD = File.createTempFile("realhowto", ".vbs");
            lf_RpDrAHoD.deleteOnExit();
            FileWriter lf_Tted9d4v = new FileWriter(lf_RpDrAHoD);
            String lf_z69fSyN8 = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\nSet colItems = objWMIService.ExecQuery _ \n   (\"Select * from Win32_BaseBoard\") \nFor Each objItem in colItems \n    Wscript.Echo objItem.SerialNumber \n    exit for  ' do the first cpu only! \nNext \n";
            lf_Tted9d4v.write(lf_z69fSyN8);
            lf_Tted9d4v.close();
            Process lf_Mp7D8ST0 = Runtime.getRuntime().exec("cscript //NoLogo " + lf_RpDrAHoD.getPath());
            BufferedReader lf_sjnSrpCM = new BufferedReader(new InputStreamReader(lf_Mp7D8ST0.getInputStream()));
            String lf_J5aCf1YO;
            while ((lf_J5aCf1YO = lf_sjnSrpCM.readLine()) != null)
                lf_NKoJJoYM = lf_NKoJJoYM + lf_J5aCf1YO;
            lf_sjnSrpCM.close();
        } catch (Exception exception) {}
        return lf_NKoJJoYM.trim();
    }

    private static String m_1okx36Ie() {
        String lf_40a9BMmi = "";
        String lf_eIJdHZmw = "dmidecode | grep 'Serial Number' | awk '{print $3}' | tail -1";
        try {
            Process lf_jdBYQBNv = Runtime.getRuntime().exec(new String[] { "sh", "-c", lf_eIJdHZmw });
            BufferedReader lf_4wajhXtk = new BufferedReader(new InputStreamReader(lf_jdBYQBNv.getInputStream()));
            String lf_3Iq5wtaq;
            if ((lf_3Iq5wtaq = lf_4wajhXtk.readLine()) != null)
                lf_40a9BMmi = lf_40a9BMmi + lf_3Iq5wtaq;
            lf_4wajhXtk.close();
        } catch (IOException iOException) {}
        return lf_40a9BMmi;
    }

    private static String m_BCElH2OO(byte[] p_87IfQCoU) {
        StringBuffer lf_1ViEUbTB = new StringBuffer();
        boolean lf_AorJXwL8 = false;
        for (byte lf_WUQHjeMX : p_87IfQCoU) {
            if (lf_AorJXwL8)
                lf_1ViEUbTB.append("-");
            byte lf_RxhiiM7g = (byte)((lf_WUQHjeMX & 0xF0) >> 4);
            lf_1ViEUbTB.append(Integer.toHexString(lf_RxhiiM7g));
            lf_RxhiiM7g = (byte)(lf_WUQHjeMX & 0xF);
            lf_1ViEUbTB.append(Integer.toHexString(lf_RxhiiM7g));
            lf_AorJXwL8 = true;
        }
        return lf_1ViEUbTB.toString().toUpperCase();
    }

    private static String m_vKzIgZ7Z() {
        InetAddress lf_hByycsww = null;
        NetworkInterface lf_YWkW0Dbg = null;
        List<String> lf_wzHO726o = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> lf_q4Z4o4r9 = NetworkInterface.getNetworkInterfaces();
            while (lf_q4Z4o4r9.hasMoreElements()) {
                lf_YWkW0Dbg = lf_q4Z4o4r9.nextElement();
                Enumeration<InetAddress> lf_iXIXTxVS = lf_YWkW0Dbg.getInetAddresses();
                while (lf_iXIXTxVS.hasMoreElements()) {
                    lf_hByycsww = lf_iXIXTxVS.nextElement();
                    if (!lf_hByycsww.isLoopbackAddress() && lf_hByycsww.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}"))
                        lf_wzHO726o.add(m_BCElH2OO(lf_YWkW0Dbg.getHardwareAddress()));
                }
            }
        } catch (Exception exception) {}
        if (lf_wzHO726o.size() > 0)
            return lf_wzHO726o.get(0);
        return "";
    }

    private static String m_qr9rhba9() {
        String lf_NHfL3t9K = null;
        BufferedReader lf_7GmqtQof = null;
        Process lf_aF629lzM = null;
        try {
            lf_aF629lzM = Runtime.getRuntime().exec("ifconfig eth0");
            lf_7GmqtQof = new BufferedReader(new InputStreamReader(lf_aF629lzM.getInputStream()));
            String lf_GY4y1c0z = null;
            int lf_WtPSXQ8P = -1;
            while ((lf_GY4y1c0z = lf_7GmqtQof.readLine()) != null) {
                lf_WtPSXQ8P = lf_GY4y1c0z.toLowerCase().indexOf("hwaddr");
                if (lf_WtPSXQ8P >= 0) {
                    lf_NHfL3t9K = lf_GY4y1c0z.substring(lf_WtPSXQ8P + "hwaddr".length() + 1).trim();
                    break;
                }
            }
        } catch (IOException iOException) {

        } finally {
            try {
                if (lf_7GmqtQof != null)
                    lf_7GmqtQof.close();
            } catch (IOException iOException) {}
            lf_7GmqtQof = null;
            lf_aF629lzM = null;
        }
        return lf_NHfL3t9K;
    }

    private static String m_ntq9FPjG() {
        String lf_gaaGZwaz = null;
        BufferedReader lf_PdNdPcRq = null;
        Process lf_fhYN6EkY = null;
        try {
            lf_fhYN6EkY = Runtime.getRuntime().exec("ifconfig");
            lf_PdNdPcRq = new BufferedReader(new InputStreamReader(lf_fhYN6EkY.getInputStream()));
            String lf_m2pPxZWp = null;
            int lf_WdqYGb2E = -1;
            while ((lf_m2pPxZWp = lf_PdNdPcRq.readLine()) != null) {
                Pattern lf_05VVRwNK = Pattern.compile("\\b\\w+:\\w+:\\w+:\\w+:\\w+:\\w+\\b");
                Matcher lf_RijxoP1t = lf_05VVRwNK.matcher(lf_m2pPxZWp);
                if (lf_RijxoP1t.find())
                    lf_gaaGZwaz = lf_RijxoP1t.group(0);
            }
        } catch (IOException iOException) {

        } finally {
            try {
                if (lf_PdNdPcRq != null)
                    lf_PdNdPcRq.close();
            } catch (IOException iOException) {}
            lf_PdNdPcRq = null;
            lf_fhYN6EkY = null;
        }
        return lf_gaaGZwaz;
    }

    private static String m_MaZldiCv() {
        String lf_gWIHK0q3 = "";
        try {
            File lf_CHy02aMS = File.createTempFile("tmp", ".vbs");
            lf_CHy02aMS.deleteOnExit();
            FileWriter lf_S3eF9bza = new FileWriter(lf_CHy02aMS);
            String lf_CvgjFiIN = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\nSet colItems = objWMIService.ExecQuery _ \n   (\"Select * from Win32_Processor\") \nFor Each objItem in colItems \n    Wscript.Echo objItem.ProcessorId \n    exit for  ' do the first cpu only! \nNext \n";
            lf_S3eF9bza.write(lf_CvgjFiIN);
            lf_S3eF9bza.close();
            Process lf_jJnaUn4I = Runtime.getRuntime().exec("cscript //NoLogo " + lf_CHy02aMS.getPath());
            BufferedReader lf_VQA2lZOB = new BufferedReader(new InputStreamReader(lf_jJnaUn4I.getInputStream()));
            String lf_LUO1ToyL;
            while ((lf_LUO1ToyL = lf_VQA2lZOB.readLine()) != null)
                lf_gWIHK0q3 = lf_gWIHK0q3 + lf_LUO1ToyL;
            lf_VQA2lZOB.close();
            lf_CHy02aMS.delete();
        } catch (Exception exception) {}
        return lf_gWIHK0q3.trim();
    }

    private static String m_pfTzeCZh() {
        String lf_06TFp2mG = "";
        String lf_r6TZLW4N = "dmidecode";
        BufferedReader lf_Dcz17r0C = null;
        Process lf_mA2fBQIq = null;
        try {
            lf_mA2fBQIq = Runtime.getRuntime().exec(new String[] { "sh", "-c", lf_r6TZLW4N });
            lf_Dcz17r0C = new BufferedReader(new InputStreamReader(lf_mA2fBQIq.getInputStream()));
            String lf_kUA4o7VC = null;
            int lf_XXrKxqSj = -1;
            while ((lf_kUA4o7VC = lf_Dcz17r0C.readLine()) != null) {
                lf_XXrKxqSj = lf_kUA4o7VC.toLowerCase().indexOf("uuid");
                if (lf_XXrKxqSj >= 0) {
                    lf_06TFp2mG = lf_kUA4o7VC.substring(lf_XXrKxqSj + "uuid".length() + 1).trim();
                    break;
                }
            }
        } catch (IOException iOException) {}
        return lf_06TFp2mG.trim();
    }

    public static String m_1O5OXzKc() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static String m_6X96rHCF() {
        String lf_u2DHF23N = m_1O5OXzKc();
        if (lf_u2DHF23N.startsWith("windows"))
            return "windows";
        if (lf_u2DHF23N.startsWith("linux"))
            return "linux";
        if (lf_u2DHF23N.startsWith("unix"))
            return "unix";
        return "";
    }

    public static String m_UTmLAP5a() {
        switch (m_6X96rHCF()) {
            case "windows":
                return m_ZZl56gPh();
            case "linux":
                return m_1okx36Ie();
        }
        return null;
    }

    public static String m_xlxymHGU() {
        String lf_CCr47jKh;
        switch (m_6X96rHCF()) {
            case "windows":
                return m_vKzIgZ7Z();
            case "linux":
                lf_CCr47jKh = m_qr9rhba9();
                if (StringUtils.isEmpty(lf_CCr47jKh))
                    lf_CCr47jKh = m_ntq9FPjG();
                return lf_CCr47jKh;
        }
        return "";
    }

    public static String m_2qZmyjZo() {
        switch (m_6X96rHCF()) {
            case "windows":
                return m_MaZldiCv();
            case "linux":
                return m_pfTzeCZh();
        }
        return null;
    }

    public static C_DEiWg4Q1 m_bni7nh0w() {
        return new C_DEiWg4Q1(m_6X96rHCF(), m_UTmLAP5a(), m_xlxymHGU(), m_2qZmyjZo());
    }

    public static String m_cnlrQ2U4() {
        String lf_swS5OsW1 = m_bni7nh0w().toString();
        return DigestUtils.sha256Hex(lf_swS5OsW1);
    }

    public static void main(String[] p_e9Prygcd) {
        String lf_mjatHq0i = m_cnlrQ2U4();
        System.out.println(lf_mjatHq0i);
    }
}
