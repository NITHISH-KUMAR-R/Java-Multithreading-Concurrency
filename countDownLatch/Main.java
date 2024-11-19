package com.JavaMultithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
     private final CountDownLatch latch = new CountDownLatch(3);

    public void worker1() throws  InterruptedException{
        Thread.sleep(3000);
        latch.countDown();
    }
    public void worker2() throws  InterruptedException{
        Thread.sleep(4000);

        latch.countDown();
    }
    public void worker3() throws InterruptedException{
        Thread.sleep(2000);

        latch.countDown();
    }
    public  void mainThread() throws InterruptedException {
        latch.await();
        System.out.println("All worker threads completed after 7 seconds");
    }


    public static void main(String[] args) throws InterruptedException {
Main employee = new Main();

  new Thread(()->{
      try {
          employee.worker1();
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  }).start();
  new Thread(()->{
            try {
                employee.worker2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

  new Thread(()->{
            try {
                employee.worker3();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    employee.mainThread();
    }
}
