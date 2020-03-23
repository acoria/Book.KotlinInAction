package com.example.kotlininaction;


import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import strings._54_ExtensionFunctionExampleKt;
import strings.GiveMeAnotherClassName;
import strings._50_TopLevelFunctionKt;

public class CallKotlinFromJava {

    Collection collection = Arrays.asList("value 1", "value 2");

    public void callPerson(){
        Person person = new Person("John");
        person.getName();
        Animal animal = new Animal("Dumbo", true);
        animal.isOld();
        animal.setOld(false);
    }

    public void callCollections(){
        //Overloaded methods
        new CollectionsInKotlin().joinToString(collection, ";");
    }

    public void callTopLevelFunction(){
        _50_TopLevelFunctionKt.joinToStringTopLevel(collection, "; ", "<", ">");
        GiveMeAnotherClassName.someTopLevelFunctionToBeCalledInJava();
    }

    public void callExtensionFunction(){
        _54_ExtensionFunctionExampleKt.lastChar("SomeString");
    }


    public void callObjectFromKotlin(){
        CaseInsensitiveFileComparator.INSTANCE.compare(new File("/user"), new File("/User"));
    }

}
