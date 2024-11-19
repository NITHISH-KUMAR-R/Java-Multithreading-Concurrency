package com.JavaMultithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int MAX_CAPACITY = 2;

    public synchronized  void produce(int data) throws InterruptedException {
        while(queue.size() == MAX_CAPACITY){
            System.out.println("waiting for consume some data");
            wait();
        }
        queue.add(data);
        System.out.println("Produce value: "+data);
        notifyAll();
    }

    public synchronized  int consume() throws InterruptedException {
        while(queue.isEmpty()){
            System.out.println("waitinng for produce some data");
            wait();
        }
        int data = queue.poll();
        System.out.println("Consume Value: "+data);
        notifyAll();
        return data;
    }
}
