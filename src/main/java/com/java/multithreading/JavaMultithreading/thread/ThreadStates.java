package com.java.multithreading.JavaMultithreading.thread;

public class ThreadStates {
    public static void main(String[] args) {
        System.out.println("Main is starting");
        Thread th = new Thread(()->{
            try{
                Thread.sleep(1);
                for(int i =10;i>0;i--){
                    System.out.println("Helllo");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        th.start();

        while(true){
            Thread.State state = th.getState();
            System.out.println(state);
            if(state == Thread.State.TERMINATED) break;
        }
    }

}
//
//NEW → RUNNABLE: When th is started using th.start().
//RUNNABLE → TIMED_WAITING: When th executes Thread.sleep(1);.
//TIMED_WAITING → RUNNABLE: After the sleep duration ends, th is ready to run again.
//RUNNABLE → TERMINATED: When the run() method completes, and th finishes execution.


//Main Method Begins
//
//The main method starts, and "Main is starting" is printed.
//Thread Creation (Thread th = new Thread(...))
//
//A new thread object th is created with a Runnable that includes a sleep(1) call followed by a for loop.
//        At this point, th is in the NEW state because it hasn’t started execution.
//Starting the Thread (th.start())
//
//The start() method is called on th, which:
//Transitions th from NEW to RUNNABLE.
//Registers the thread with the JVM and OS, making it eligible for scheduling.
//        The run() method of th is set to execute as soon as the OS schedules it.
//Thread State Monitoring in Main Loop
//
//The main thread enters a while loop to continuously check and print the state of th.
//The first printed state is RUNNABLE because th has started and is ready to run (though it may not be actively using the CPU yet).
//Thread th Execution - Entering TIMED_WAITING State
//
//When th gets CPU time, it enters the run() method.
//The first statement in run() is Thread.sleep(1);.
//What happens during Thread.sleep(1);:
//th is transitioned into the TIMED_WAITING state because sleep() pauses its execution for approximately 1 millisecond.
//        In this state, th doesn’t consume CPU resources; it’s marked as temporarily inactive by the OS.
//Extended TIMED_WAITING Output
//
//The main thread continues checking the state of th while it’s sleeping, so you see many TIMED_WAITING prints in the output.
//Although sleep(1) specifies a 1-millisecond delay, the actual sleep duration may vary depending on the OS scheduler and CPU load, which can make TIMED_WAITING appear for longer.
//Back to RUNNABLE after Sleep Ends
//
//After the sleep duration ends, the JVM marks th as RUNNABLE again.
//        However, th is not guaranteed immediate CPU access; it has to wait until the OS schedules it.
//Once th is scheduled, it resumes with the next statement: the for loop.
//Execution of the for Loop (Staying in RUNNABLE)
//
//The for loop in th counts down from 10 to 0. This loop is executed quickly, so it stays in the RUNNABLE state.
//        During this time, the main thread prints several RUNNABLE states as it checks th repeatedly.
//End of Thread Execution - TERMINATED State
//
//When th completes the for loop, the run() method ends.
//The JVM marks th as TERMINATED, signaling the end of its lifecycle. All resources used by th are deallocated by the JVM.
//The main thread’s while loop detects the TERMINATED state, breaks out of the loop, and the program ends.