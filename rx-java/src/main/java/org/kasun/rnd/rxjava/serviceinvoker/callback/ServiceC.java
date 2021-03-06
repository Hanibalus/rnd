package org.kasun.rnd.rxjava.serviceinvoker.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ServiceC implements Runnable {
    final static ExecutorService executor = new ScheduledThreadPoolExecutor(5);
    private Callback<String> clientCallback;
    private String request;

    public void callAsync(String msg, Callback<String> callback) {
        this.clientCallback = callback;
        request = msg;
        executor.submit(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clientCallback.completed("<ServiceC>" + request + "</ServiceC>");
    }

}
