package com.java.multithreading.JavaMultithreading;

public class Deadlock {
    public static void main(String[] args) {
        System.out.println("Main thread");
        Object lock1 = "Nithish";
        Object lock2 ="Sobiya";
        Thread t1 = new Thread(()->{
            synchronized (lock1){
                System.out.println("No lock in t1");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("DeadLocked here");
                }
            }
        },"thread1");
        Thread t2 = new Thread(()->{
            synchronized (lock2){
                System.out.println("No lock in t2");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1){
                    System.out.println("DeadLocked here");
                }
            }
        },"thread2");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Main thread end");
    }
}
