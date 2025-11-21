package com.gitee.freakchicken.dbapi.basic.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class C_GEUoaMz4 {
    private static ThreadFactory gf_BFQCf84h = (new ThreadFactoryBuilder()).setNameFormat("alarm thread pool").build();

    private static ExecutorService gf_HD3cSZ9N = Executors.newFixedThreadPool(1, gf_BFQCf84h);

    public static void m_TF0xFtGb(Runnable p_1YvPaj8a) {
        gf_HD3cSZ9N.submit(p_1YvPaj8a);
    }
}
