package com.JavaMultithreading.threadDemo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Class Started");
        Thread1 t1 = new Thread1();
        t1.setDaemon(true); // Marking the thread as a daemon thread.
        // The JVM does not wait for daemon threads to complete execution before terminating the program.
        // JVM prioritizes user threads and will exit once all user threads are finished.
        t1.start();
        //Even though t1 is daemon threads do not prevent the JVM from exiting  but
        //when we use join in daemon thread main thread will wait for t1 to finish
        // which effectively keeps the JVM alive until t1 completes, even though t1 is a daemon thread
        t1.join(); //try comment and uncomment
        Thread thread2 = new Thread(new RunnableThread());
        thread2.start();

        // Recommended approach for implementing threads is using the Runnable interface with a lambda expression.
        // We pass a Runnable instance because Java supports multiple interface implementation but not multiple inheritance.

        // Here, the Thread constructor accepts an implementation of the Runnable interface, which we pass as a lambda.
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++)
                System.out.println("Current Thread 3: " + Thread.currentThread().getName() + " " + i);
        });

        t3.start();
        System.out.println("Main Class ended");
        //if any one is trying to run this main never going to get the same output if i set thread1 to daemonThread
    }
}
