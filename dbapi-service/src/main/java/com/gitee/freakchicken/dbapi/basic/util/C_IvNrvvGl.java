package com.gitee.freakchicken.dbapi.basic.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C_IvNrvvGl {
    private static final Logger log = LoggerFactory.getLogger(C_IvNrvvGl.class);

    public static String m_Fu3Jsub1(String p_TR5CIFRa, String p_wDqCOdrq) {
        Calendar lf_VTQEZZvJ = Calendar.getInstance();
        lf_VTQEZZvJ.add(12, 60);
        Date lf_kJ1Ia4j2 = lf_VTQEZZvJ.getTime();
        return

                JWT.create().withAudience(new String[] { p_TR5CIFRa }).withIssuedAt(new Date()).withExpiresAt(lf_kJ1Ia4j2).sign(Algorithm.HMAC256(p_wDqCOdrq));
    }

    public static boolean m_9dsDIXxD(String p_3k99u2Qn, String p_OZ1f2PAW) {
        JWTVerifier lf_64OyMEFQ = JWT.require(Algorithm.HMAC256(p_OZ1f2PAW)).build();
        try {
            lf_64OyMEFQ.verify(p_3k99u2Qn);
            return true;
        } catch (JWTVerificationException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public static String m_s16vRQtu(String p_PyacibTe) {
        String lf_90g5YNnH = null;
        try {
            lf_90g5YNnH = JWT.decode(p_PyacibTe).getAudience().get(0);
        } catch (JWTDecodeException jWTDecodeException) {}
        return lf_90g5YNnH;
    }

    public static Claim m_Jd6o4mhP(String p_yU9uixAC, String p_yDzSXbEG) {
        return JWT.decode(p_yU9uixAC).getClaim(p_yDzSXbEG);
    }
}
