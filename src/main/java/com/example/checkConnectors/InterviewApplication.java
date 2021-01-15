package com.example.checkConnectors;

import com.example.checkConnectors.tasks.models.Pair;
import com.example.checkConnectors.tasks.services.CheckConnectors;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class InterviewApplication {


    public static void main(String[] args) throws InterruptedException {
        List<Pair> pairList = new LinkedList<>();
        Pair p1 = new Pair(1, 2);
        Pair p2 = new Pair(1, 7);
        Pair p3 = new Pair(15, 12);
        Pair p4 = new Pair(17, 18);
        Pair p5 = new Pair(17, 14);
        Pair p6 = new Pair(17, 13);
        Pair p7 = new Pair(13, 2);
        Pair p8 = new Pair(15, 2);
        pairList.add(p1);
        pairList.add(p2);
        pairList.add(p2);
        pairList.add(p3);
        pairList.add(p4);
        pairList.add(p5);
        pairList.add(p6);
        pairList.add(p7);
        pairList.add(p8);

        CheckConnectors check = new CheckConnectors();
        int check1 = check.check(pairList);
        System.out.println(check1);
    }

}