package com.java.multithreading.JavaMultithreading;

public class RunnableThread implements  Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("Runnable Thread"+ Thread.currentThread());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
