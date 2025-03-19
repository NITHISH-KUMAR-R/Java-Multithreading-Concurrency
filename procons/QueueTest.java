package com.JavaMultithreading.procons;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class QueueTest {

    private int capacity;
    private Queue<Integer> q;

    QueueTest(int cap){
        capacity = cap;
        q =new LinkedList();

    }

    public synchronized  boolean  add(int a){
//if can cause spurious wake-ups and race conditions. while ensures that the condition is rechecked after waking up.
        while(q.size()==capacity){
            try {
                System.out.println("Waiting to popped");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        q.add(a);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
        return true;
    }

    public  synchronized  int remove(){
        //if can cause spurious wake-ups and race conditions. while ensures that the condition is rechecked after waking up.
        while(q.size()==0){
            try {
                System.out.println("waiting to be added");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        int popped =  q.poll();
        notifyAll();

        return  popped;
    }
}

//🔴 if: Checks once → Waits → Assumes the condition remains valid after waking up. ❌ Risky!
//🟢 while: Keeps checking → Waits → Re-validates the condition after waking up. ✅ Safe!

//🔴 if (Bad Way) → You assumed cookies were there after waking up. But someone else took them first, and now you are sad. 😢
//
//🟢 while (Good Way) → You check again after waking up. If cookies are gone, you wait again until they really come. 😊