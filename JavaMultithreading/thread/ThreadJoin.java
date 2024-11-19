package com.java.multithreading.JavaMultithreading.thread;

public class ThreadJoin {
    public static void main(String[] args) {
        System.out.println("Main is starting");
        Thread th1  = new Thread(()->{
            System.out.println("Join thread task");
        },"userThread");

//
//        try {
//            th1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }



    Thread th2 = new Thread(()->{
        System.out.println("Thread 2 running");
    },"thread2");


        th1.setPriority(Thread.MIN_PRIORITY);
        th2.setPriority(Thread.MAX_PRIORITY);
        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main is Existing");
    }}
