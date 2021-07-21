package com.mahendracandi.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // check processors
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("available processors: " + i);

        // initiate executorService
        ExecutorService taskList = Executors.newFixedThreadPool(200);

        // create new runnable instance
        MyRunnable threadx = new MyRunnable("threadx");
        MyRunnable thready = new MyRunnable("thready");
        MyRunnable threadz = new MyRunnable("threadz");

        // execute runnable class
        taskList.execute(threadx);
        taskList.execute(thready);
        taskList.execute(threadz);

        // running 100 threads
        new OtherApp().startThread();

        // running new app1
        new App1();
    }
}
