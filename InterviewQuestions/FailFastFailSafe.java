package com.JavaMultithreading.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {

    public static void main (String a[]){

        List<String>  failFast = new ArrayList<>();

        failFast.add("apple");
        failFast.add("mabgo");

        //.ConcurrentModificationException
        for(String s: failFast){
            //.ConcurrentModificationException
            //failFast.add("m");
           // list.add(s);
        }


        CopyOnWriteArrayList<String> failSafe = new CopyOnWriteArrayList<>();
        failSafe.add("apple");
        failSafe.add("mango");

        for(String s: failSafe){
            failSafe.add("amma");
        }

        System.out.println("fail Safe: "+failSafe);
    }
}
