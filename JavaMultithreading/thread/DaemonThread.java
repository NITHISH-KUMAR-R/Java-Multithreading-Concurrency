package com.java.multithreading.JavaMultithreading.thread;

public class DaemonThread extends   Thread{

    public void run(){
        while(true){
            try{
                System.out.println("Daemon Thread is started running "+Thread.currentThread());
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
