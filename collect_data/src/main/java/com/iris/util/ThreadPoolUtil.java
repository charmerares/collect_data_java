package com.iris.util;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {
    public static volatile ThreadPoolExecutor threadPoolExecutor = null;

    private static synchronized void initThreadPoolCheck() {
        if (threadPoolExecutor == null) {
            threadPoolExecutor = new ThreadPoolExecutor(4, 10, 60,
                    TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.DiscardOldestPolicy());
        }
    }

    public static void shutdown() {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            threadPoolExecutor = null;
        }
    }

    public static void addNewTaskWithoutResult(Runnable runnable){
        initThreadPoolCheck();
        threadPoolExecutor.execute(runnable);
    }
}
