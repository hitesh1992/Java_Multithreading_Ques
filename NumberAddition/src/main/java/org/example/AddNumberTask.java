package org.example;

import java.util.ArrayList;
import java.util.List;

public class AddNumberTask implements Runnable{

    public static volatile Integer  numSum=0;
    public List<Integer> listNum= new ArrayList<>();

    public AddNumberTask(List<Integer> listNum){
        this.listNum=listNum;
    }

    @Override
    public void run() {
        for(Integer  i:listNum){
            System.out.println("Number: "+i+" is add to sum by thread: "+Thread.currentThread().getName());
            numSum+=i;
        }
    }

    public static Integer getNumSum() {
        return numSum;
    }

}
