package com.example.kotlininaction;

public class SAMinterfaceJava {

    void postponeComputation(int delay, Runnable computation){
        //delay, then
        computation.run();
    }
}
