package com.java.multithreading.JavaMultithreading.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(5); // Initialize with 4 parties

        Runnable task = (() -> {
            //phaser.register();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " Arrived");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " Continued");
        });

        Runnable task2 = (() -> {
            //phaser.register();
            System.out.println(Thread.currentThread().getName() + " Arrived task2");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " Continued task2 ");
        });

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task2).start();
        new Thread(task2).start();
        new Thread(task2).start();

        // This is for main Thread
        phaser.register();
        System.out.println(Thread.currentThread().getName() + " thread is waiting");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " thread continued");
        phaser.arriveAndDeregister();
    }
}
