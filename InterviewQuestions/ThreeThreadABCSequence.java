package com.JavaMultithreading.InterviewQuestions;

import java.util.concurrent.Semaphore;

public class ThreeThreadABCSequence {

    Semaphore semA = new Semaphore(1);
    Semaphore semB = new Semaphore(0);
    Semaphore semC = new Semaphore(0);

    int permitCount =5;

    Thread t1 = new Thread(()->{
        for(int i =0;i<permitCount ;i++){
            try {
                semA.acquire();
                System.out.print("A");
                semB.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    Thread t2 = new Thread(()->{
        for(int i =0;i<permitCount ;i++){
            try {
                semB.acquire();
                System.out.print("B");
                semC.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });
    Thread t3 = new Thread(()->{
        for(int i =0;i<permitCount ;i++){
            try {
                semC.acquire();
                System.out.print("C");
                semA.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    public static  void main(String a[]){

        ThreeThreadABCSequence obj = new ThreeThreadABCSequence();
        obj.t1.start();
        obj.t2.start();
        obj.t3.start();
    }


}
