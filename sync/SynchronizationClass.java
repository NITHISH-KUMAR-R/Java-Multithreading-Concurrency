package com.JavaMultithreading.sync;

public class SynchronizationClass {
    public static void main(String[] args) {

        Stack st = new Stack(5);

        Thread t1  = new Thread(()->{
            int counter =0;
           for(int i =0;i<10;i++){
                System.out.println("popped: "+st.pop());
            }
        },"popThread");
       Thread t2 =  new Thread(()->{
            int counter =0;
           for(int i =0;i<10;i++){
                System.out.println("Pushed: "+st.push(i));
            }
        },"PushThread;");

      // t1.setPriority(5);
       t2.start();
       t1.start();





    }
}
