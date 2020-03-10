package com.example.kotlininaction.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestClass {

    public static void main(String[] args){

        ClassToSerialize classToSerialize = new ClassToSerialize();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("filename.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            out.writeObject(classToSerialize);
            out.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
