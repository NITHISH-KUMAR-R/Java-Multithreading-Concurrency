package com.java.multithreading.JavaMultithreading.phaser;

import java.util.concurrent.Phaser;

public class Main2 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);

        Runnable task = (() -> {
            phaser.register();
            for (int phase = 0; phase < 4; phase++) {
                System.out.println(Thread.currentThread().getName() + "Arrived at " + phase);
                phaser.arriveAndAwaitAdvance();
                System.out.println("Continued");
            }
            phaser.arriveAndDeregister();
        });

        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }

        for (int phase = 0; phase < 4; phase++) {
            System.out.println("Main thread arrived at phase " + phase);
            phaser.arriveAndAwaitAdvance();
        }
        System.out.println("main thread ends");
        phaser.arriveAndDeregister();

    }
}
