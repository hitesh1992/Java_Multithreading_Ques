package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numLst = IntStream.range(1,1001).boxed().collect(Collectors.toList());
        int startIndex=0;
        for(int i=1;i<=5;i++){
            AddNumberTask task = new AddNumberTask(numLst.subList(startIndex, startIndex+200));
            Thread t =new Thread(task);
            t.setName("Thread "+i);
            t.start();
            startIndex+=200;
        }

        Thread.sleep(5000);
        System.out.println("Sum = "+AddNumberTask.getNumSum());
    }
}