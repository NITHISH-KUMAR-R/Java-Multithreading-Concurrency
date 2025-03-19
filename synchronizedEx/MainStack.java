package com.JavaMultithreading.synchronizedEx;

public class MainStack {
    public static void main(String[] args) throws InterruptedException {
        Stack st = new Stack(10);
        Thread t1  = new Thread(()->{
            for(int i =1;i<10;i++){
                System.out.println("Push Thread 1 "+Thread.currentThread()+ " " +st.push(i));
            }
        });
        Thread t2 = new Thread(()->{
            for(int i =1;i<10;i++){
                System.out.println("Pop Thread "+Thread.currentThread()+" "+st.pop());
            }
        });

        t1.start();
        t2.start();

        //How alternate Execution if synchronized block uses same lock it will release after each iteration
        //meaning once block ends it will release lock after sleep time - next other thread will acquire that lock and uses it

        //Lock - we can use all Wrapper objects as lock Integer,String and Object anything  - but not primitive types
        //if we let t1 acquire lock first to complete all 10 iterations we need to
        //do changes in start t1.start() , t1.join(), t2.start() this way we are telling first complete t1 and then move to t2.

        //🔹 Every object in Java has a built-in lock (also called a monitor).
    }
}
