package com.JavaMultithreading.thread;

public class RunnableThread implements  Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("Runnable Thread"+ Thread.currentThread());
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
