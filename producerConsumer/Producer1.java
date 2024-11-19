package com.JavaMultithreading.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer1 implements  Runnable{
    private BlockingQueue<Integer> blockingQueue;
      Producer1(BlockingQueue<Integer> bq){
        this.blockingQueue = bq;
    }
    public  void run(){
       try{ for(int i =0;i<10;i++){
            blockingQueue.put(i);
           System.out.println("Produce data from BQ queue "+i);

           Thread.sleep(1000);
        }}catch(Exception e){
            e.printStackTrace();
        }
    }
}

 class Consumer1 implements  Runnable {
    private BlockingQueue<Integer> blockingQueue;
       Consumer1(BlockingQueue<Integer> bq){
         this.blockingQueue = bq;
     }
    public  void run(){
        try{
            for(int i =0;i<10;i++){
           int data =  blockingQueue.take();
                System.out.println("Consume data from BQ queue "+data);
            Thread.sleep(1000);
        }}catch(Exception e){
            e.printStackTrace();
        }
    }
}
