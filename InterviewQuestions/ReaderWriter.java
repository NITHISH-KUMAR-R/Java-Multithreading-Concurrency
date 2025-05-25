package com.JavaMultithreading.InterviewQuestions;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriter {

    public static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public static ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    public static ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    private static int value = 0;

    public static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is reading: " + value);
            Thread.sleep(1000); // Simulate read time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            readLock.unlock();
        }
    }

    public static void write(int newValue) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is writing: " + newValue);
            Thread.sleep(1000); // Simulate write time
            value = newValue;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        // Create Reader Threads
        Runnable readerTask = () -> {
            for (int i = 0; i < 20; i++) {
                read();
                try {
                    Thread.sleep(500); // Give time for writers to sneak in
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };


        // Create Writer Threads
        Runnable writerTask = () -> {
            for (int i = 1; i < 10; i++) {
                write((int) (i * 100));
            }
        };

        // Start Threads
        Thread r1 = new Thread(readerTask, "Reader-1");
        Thread r2 = new Thread(readerTask, "Reader-2");
        Thread r3 = new Thread(readerTask, "Reader-3");

        Thread w1 = new Thread(writerTask, "Writer-1");
        Thread w2 = new Thread(writerTask, "Writer-2");

        r1.start();
        r2.start();
        w1.start();
        r3.start();
        w2.start();
    }
}
