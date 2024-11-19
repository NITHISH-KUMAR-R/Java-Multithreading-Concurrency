package com.java.multithreading.JavaMultithreading;

public class Thread1 extends  Thread {

    @Override
    public void run(){
        System.out.println("Started sleeping for 3 seconds");
            try {
                System.out.println("Thread1 name "+ Thread.currentThread());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println("User Thread ending here");
        }
    }

