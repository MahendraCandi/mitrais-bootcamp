package com.mahendracandi.concurrent;

public class MyRunnable implements Runnable{

    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running thread: " + threadName);
        System.out.println(Thread.currentThread().getName());
    }
}
