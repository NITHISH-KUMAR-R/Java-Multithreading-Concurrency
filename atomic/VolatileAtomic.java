package com.JavaMultithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomic {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static  volatile boolean stopFlag = false;
    private static void doWork(){
        while(!stopFlag){
            atomicInteger.incrementAndGet();
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        Thread t1 = new Thread(VolatileAtomic::doWork);
        Thread t2 = new Thread(VolatileAtomic::doWork);

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
            stopFlag=true;
            t1.join();
            //t2.start();
           // stopFlag=false;
            t2.join();
            //stopFlag=true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("count: " + atomicInteger.get());

    }
}
