package com.company;

/**
 * Created by klimas on 03.12.15.
 */


public class DroolsThread extends Thread {
    public Thread t;
    private String threadName;
    private Main main;

    DroolsThread(String name, Main main_) {
        threadName = name;
        main = main_;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            main.setKnowledgeBAse(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public void Wait() {
        try {
            Thread.sleep(5000000);
        } catch (InterruptedException e) {
        }
    }

}
