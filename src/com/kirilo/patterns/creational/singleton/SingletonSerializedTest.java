package com.kirilo.patterns.creational.singleton;

import com.kirilo.patterns.creational.singleton.singletons.SerializationSingleton;

import java.io.*;

public class SingletonSerializedTest {
    public static void main(String[] args) throws ClassNotFoundException {
        SerializationSingleton singleton = SerializationSingleton.getInstance();
        try {
            File tempFile = File.createTempFile("someFile", "serial");
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream(tempFile));
            output.writeObject(singleton);
            output.flush();
            output.close();

            String absolutePath = tempFile.getAbsolutePath();
            System.out.println(absolutePath);
            ObjectInput input = new ObjectInputStream(new FileInputStream(absolutePath));
            SerializationSingleton singletonTwo = (SerializationSingleton) input.readObject();
            input.close();

            System.out.println("singleton.hashCode(): " + singleton.hashCode());
            System.out.println("singleton.getValue(): " + singleton.getValue());
            System.out.println("singletonTwo.hashCode(): " + singletonTwo.hashCode());
            System.out.println("singletonTwo.getValue(): " + singletonTwo.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
