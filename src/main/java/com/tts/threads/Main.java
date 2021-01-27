package com.tts.threads;

import java.sql.SQLOutput;
import java.util.List;

public class Main {

    private String lastName;
    private int nameCount;
    private List<String> nameList;

    public void addName(String name) {
        synchronized (this) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new HelloRunnable("Hello from the first thread"));
        Thread threadTwo = new Thread(new HelloRunnable("Hello from the second thread"));
        Thread threadThree = new Thread(new HelloRunnable("Hello from the third thread"));

        thread.start();
        threadTwo.start();
        threadThree.start();

        Runnable runnable = () ->
            System.out.println("Hello from lambda");

        Thread functionalThread = new Thread(runnable);

        functionalThread.start();

        Runnable pausableRunnable = () -> {

            try {
                System.out.println("Hold on, I have to take a quick nap...");
                Thread.sleep(4000);
                System.out.println("Hello from pausable lambda");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread pausedThread = new Thread(pausableRunnable);
        pausedThread.start();

        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        Runnable myRunnableSync = () -> {
            synchronizedCounter.increment();
            System.out.println("Number from sync counter: " + synchronizedCounter.value());
        };

        Thread myThreadSync = new Thread(myRunnableSync);
        Thread myOtherThreadSync = new Thread(myRunnableSync);

        myThreadSync.start();
        myOtherThreadSync.start();

        System.out.println("Number from sync counter: " + synchronizedCounter.value());
    }
}


