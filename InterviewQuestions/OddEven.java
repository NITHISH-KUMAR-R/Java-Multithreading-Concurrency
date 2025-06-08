package com.JavaMultithreading.InterviewQuestions;

public class OddEven {

    public Object nithish =  new Object();

    public volatile  int i =0;

    Runnable r1 = ()->{
        while(i<40){
            synchronized (nithish) {
                if (i % 2 == 0) {
                    System.out.println("EVen " + i);
                    i++;
                    nithish.notify();
                } else {
                    try {
                        nithish.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    };


    Runnable r2 = ()->{
       while(i<40) {
            synchronized (nithish) {
                if (i %2!= 0) {
                    System.out.println("Odd " + i);
                    i++;
                    nithish.notify();
                } else {
                    try {
                        nithish.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    };
    public static void main(String a[]){

        OddEven obj = new OddEven();
        new Thread(obj.r1).start();
        new Thread(obj.r2).start();



    }
}
