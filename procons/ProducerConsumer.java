package com.JavaMultithreading.procons;

public class ProducerConsumer {
    public static void main(String[] args) {

        QueueTest q = new QueueTest(2);
        Thread t1 = new Thread(()->{
            for(int i =1;i<10;i++){
                System.out.println("Added "+q.add(i));
            }
        });
        Thread t2 = new Thread(()->{
            for(int i =1;i<10;i++){
                System.out.println("Popped: " +q.remove());
            }
        });

        t1.start();
        t2.start();

    }

}
