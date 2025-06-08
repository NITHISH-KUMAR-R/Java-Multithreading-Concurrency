package com.JavaMultithreading.InterviewQuestions;

import java.util.concurrent.Semaphore;

public class AlternatePrinterSem {

    Semaphore semA = new Semaphore(1);
    Semaphore semB = new Semaphore(0);

    Thread t1 = new Thread(()->{
        for(int i =0;i<26;i++){
            try {
                semA.acquire();
                System.out.print(i+" ");
                semB.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    Thread t2 = new Thread(()->{
        for(char c ='a';c<'z';c++){
            try {
                semB.acquire();
                System.out.print(c+" ");
                semA.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });


    public static  void main(String a[]){
        AlternatePrinterSem obj = new AlternatePrinterSem();
        obj.t1.start();;
        obj.t2.start();

    }
}
