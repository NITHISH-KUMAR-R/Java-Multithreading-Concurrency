package com.JavaMultithreading.thread;

public class UserThread  extends  Thread{

    public void run(){
        System.out.println("User Thread Started running and sleeping for few seconds");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("User thread ending after 3 seconds");

    }
}
