package com.JavaMultithreading.threadDemo;

public class Thread1 extends  Thread{
    @Override
    public void run(){
        for(int i =0;i<10;i++){
            System.out.println("Current Thread: "+ Thread.currentThread()+ " "+i);
        }
    }

}
