package com.java.multithreading.JavaMultithreading;

public class Thread1 extends  Thread {

    @Override
    public void run(){
        for(int i =0;i<10;i++){
            try {
                System.out.println("Normal Thread"+ Thread.currentThread());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
