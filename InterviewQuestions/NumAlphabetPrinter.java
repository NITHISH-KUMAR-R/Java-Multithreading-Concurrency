package com.JavaMultithreading.InterviewQuestions;

public class NumAlphabetPrinter {

    public String nithishLock = "nithish";
    public volatile  boolean isNumberTurn = true;
    Runnable r1 = ()->{
        for(int i =1;i<=26;i++){
            synchronized(nithishLock){
                while(!isNumberTurn){
                    try {
                        nithishLock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(" Number Turn: "+i);
                isNumberTurn = false;
                nithishLock.notify();

            }
        }

    };

    Runnable r2 = ()->{

        for(char i ='a';i<='z';i++){
            synchronized(nithishLock){
                while(isNumberTurn){
                    try {
                        nithishLock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(" Alpha Turn: "+i);
                isNumberTurn = true;
                nithishLock.notify();

            }
        }

    };



    public static void main(String a[]){

        NumAlphabetPrinter printer = new NumAlphabetPrinter();
        new Thread(printer.r1).start();
        new Thread(printer.r2).start();
    }
}
