package com.java.multithreading.JavaMultithreading.sync;

public class SynchronizationClass {
    public static void main(String[] args) {

        Stack st = new Stack(5);

        new Thread(()->{
            int counter =0;
            while(++ counter <10){
                System.out.println("popped: "+st.pop());
            }
        }).start();
        new Thread(()->{
            int counter =0;
            while(++ counter <10){
                System.out.println("Pushed: "+st.push(45));
            }
        }).start();






    }
}
