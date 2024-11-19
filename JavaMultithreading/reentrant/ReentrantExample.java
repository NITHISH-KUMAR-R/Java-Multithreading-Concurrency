package com.java.multithreading.JavaMultithreading.reentrant;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantExample {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    //private  final ReentrantReadWriteLock.ReadLock  readlock = lock.readLock();
   // private  final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    int shared =0;
    public int readLock(){

        lock.readLock().lock();
        try{
            System.out.println("Thread name  "+ Thread.currentThread().getName() +"Read resource "  + shared);
            return shared;
        }finally {
            lock.readLock().unlock();        }

    }

    public void writeLock(int value){

        lock.writeLock().lock();
        try{
            shared = value;
            System.out.println("Thread is writing "+Thread.currentThread().getName() +" " + shared);

        }finally {
            lock.writeLock().unlock();
        }

    }

}
