package com.example.kotlininaction.serialization;

import java.io.Serializable;

public class ClassToSerialize implements Serializable {

    private int number = 1;
    String name = "My name";
    NonSerializableClass nonSerializableClass = new NonSerializableClass();

    class InnerClass{
        void doSomething(){
            ClassToSerialize.this.number = 10;
        }
    }

}
