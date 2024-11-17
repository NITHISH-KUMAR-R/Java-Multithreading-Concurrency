package com.java.multithreading.JavaMultithreading.reentrant;

public class Main {
    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
//        Runnable readlock = (()->{
//            for(int i =0;i<2;i++){
//                System.out.println("Read Example: "+ example.readLock());
//                try{
//                    Thread.sleep(1000);
//                }catch(InterruptedException  e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        Runnable wirteLock = (()->{
//            for(int i =0;i<1;i++){
//                example.writeLock(45);
//                    try{
//                    Thread.sleep(1000);
//                }catch(InterruptedException  e){
//                    e.printStackTrace();
//                }
//            }
//        });


        new Thread(example::readLock).start();
        new Thread(()->example.writeLock(10)).start();
        new Thread((example::readLock)).start();
        new Thread(()->example.writeLock(45)).start();
        new Thread(example::readLock).start();
        new Thread(()->example.writeLock(89)).start();
        new Thread(example::readLock).start();
        new Thread(example::readLock).start();
        new Thread(example::readLock).start();
        new Thread(example::readLock).start();
        new Thread(()->example.writeLock(100)).start();
        new Thread(example::readLock).start();








//        Thread  t1 = new Thread(readlock);
//        Thread t2 = new Thread(wirteLock);
//
//        Thread  t3 = new Thread(readlock);
//        Thread t4 = new Thread(wirteLock);
//        Thread  t5 = new Thread(readlock);
//        Thread t6 = new Thread(wirteLock);

//        t1.start();
//        t2.start();
//
////        t4.start();
////        t5.start();
////        t6.start();
//       t3.start();

    }
}
