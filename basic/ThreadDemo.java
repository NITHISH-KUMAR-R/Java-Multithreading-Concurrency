package com.JavaMultithreading.basic;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread starting");
        Thread t1 = new Thread(new PrintN(),"PrintThread");
        t1.setDaemon(true);

        Thread t2 = new Thread(()->{
            for(int i =0;i<20;i++){
                System.out.println("Killing you "+i);
            }
        });
        t2.setDaemon(true);
        t2.start();
       // t2.join();

        t1.start();
        Thread.sleep(2000);
        System.out.println("Main Thread : ending" );

    }
}
