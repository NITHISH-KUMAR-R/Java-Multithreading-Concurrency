package com.java.multithreading.JavaMultithreading;

public class RunnableThread implements  Runnable{

    @Override
    public void run() {
        for(int i =0;i<10;i++){
            try{
                System.out.println("Runnable Thread"+ Thread.currentThread());
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
