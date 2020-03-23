package com.example.kotlininaction;

//Java function interfaces == SAM single abstract interface
//An interface with only one abstract method, e.g. View.OnClickListener with OnClick(v: View)
public class SAMinterfaceJava {

    void postponeComputation(int delay, Runnable computation){
        //delay, then
        computation.run();
    }
}
