package com.gitee.freakchicken.dbapi.basic.util;

import com.gitee.freakchicken.dbapi.basic.domain.User;

public class C_LCGXNEh5 {
    private static ThreadLocal<User> gf_5jraSvJi = new ThreadLocal<>();

    public static Integer m_4r4IiO0Z() {
        User lf_RNxuY4CR = gf_5jraSvJi.get();
        return (lf_RNxuY4CR == null) ? null : lf_RNxuY4CR.getId();
    }

    public static void m_5Y7ZjtMP(User p_cODIYa5g) {
        gf_5jraSvJi.set(p_cODIYa5g);
    }

    public static void m_R2RuOATz() {
        gf_5jraSvJi.remove();
    }
}
