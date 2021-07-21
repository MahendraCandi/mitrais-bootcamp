package com.mahendracandi.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OtherApp {

    public void startThread() {
        int poolSize = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        for (int i = 1; i <= 100; i++) {
            executorService.execute(new MyRunnable("Other Thread: " + i));
        }
    }
}
