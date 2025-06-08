package com.JavaMultithreading.InterviewQuestions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenSem {

    Semaphore semA  = new Semaphore(1);
    Semaphore semB = new Semaphore(0);
    private volatile  int i =2;
   //AtomicInteger ai = new AtomicInteger(2);

    Thread t1 = new Thread(()->{
       while(i<50) {
           if (i % 2 == 0) {
               try {
                   semA.acquire();
                   System.out.println("Even "+i);
                   i++;
                   //ai.getAndIncrement();
                   semB.release();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }
    });

    Thread t2 = new Thread(()->{
        while(i<50){
            if (i % 2 != 0) {
                try {
                    semB.acquire();
                    System.out.println("Odd "+i);
                    i++;
                    //ai.getAndIncrement();
                    semA.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });

    public static  void main(String a[]){

        OddEvenSem obj = new OddEvenSem();
        obj.t1.start();
        obj.t2.start();

    }
}
