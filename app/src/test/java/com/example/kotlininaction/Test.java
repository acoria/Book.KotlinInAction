package com.example.kotlininaction;

import com.example.kotlininaction.javaExamples.Num;
import com.example.kotlininaction.javaExamples.Sum;

public class Test {

    @org.junit.Test
    public void sumItUp(){

        //(1 + 2) + 4
        Sum sum = new Sum(new Sum(new Num(1),new Num(2)),new Num(4));
        System.out.println(sum.getSum());
    }
}
