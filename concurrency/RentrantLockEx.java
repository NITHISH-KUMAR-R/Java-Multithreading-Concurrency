package com.JavaMultithreading.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockEx {
    Lock lock = new ReentrantLock();
    int count =0;
    public void increment(){
        lock.lock();
        try{
            count++;
            System.out.println("Reentrant Lock count: "+count);
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        RentrantLockEx rt  = new RentrantLockEx();
        Thread t1 = new Thread(rt::increment);
        Thread t2 = new Thread(rt::increment);

        t1.start();
        t2.start();





    }
}
