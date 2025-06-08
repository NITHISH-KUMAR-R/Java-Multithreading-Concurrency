package com.JavaMultithreading.InterviewQuestions;

public class AlternatePrinter {
    private static final Object lock = new Object();
    private static  volatile  boolean isNumberTurn = true;
    public static void main(String[] args) {

        Thread numThread = new Thread(()->{
            synchronized (lock){
            for(int i =1;i<=26;i++){
                 while(!isNumberTurn){
                     try{
                        lock.wait();
                        Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 }
                 System.out.println(i + ", ");
                 isNumberTurn = false;
                 lock.notify();
             }
            }
        });

        Thread letterThread = new Thread(()->{
            synchronized (lock){

                for(char c = 'A' ;c<='Z';c++){
                    while(isNumberTurn){
                        try{
                            lock.wait();
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(c+" ,");
                    isNumberTurn = true;
                    lock.notify();
                }
            }

        });

        numThread.start();
        letterThread.start();

    }
}
