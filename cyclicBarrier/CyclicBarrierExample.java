package com.JavaMultithreading.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static  class Task implements Runnable{
        private CyclicBarrier cyclicBarrier;
        public Task(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Waiting for barrier "+Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Crossed the barriers "+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All Threads arrived at the barrier");
            }
        });


        Thread t1 = new Thread(new Task(cb),"Thread1");
        Thread t2 = new Thread(new Task(cb),"Thread2");
        Thread t3 = new Thread(new Task(cb),"Thread3");

        t1.start();;
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t4 = new Thread(new Task(cb), "Thread4");
        Thread t5 = new Thread(new Task(cb), "Thread5");
        Thread t6 = new Thread(new Task(cb), "Thread6");

        t4.start();
        t5.start();
        t6.start();


    }
}
