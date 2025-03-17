package com.JavaMultithreading.threadDemo;

public class RunnableThread implements  Runnable{
    @Override
    public void run() {
        for(int i =0;i<10;i++){
            System.out.println("Current Thread i: "+Thread.currentThread()+ " "+i);
        }
    }
}
