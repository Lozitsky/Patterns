package com.kirilo.patterns.structural.decorator;

import com.kirilo.patterns.structural.decorator.decorators.*;

public class Demo {
    public static void main(String[] args) {
        String someString = "This is some string,\n and one another string.";
        String fileName = "E:/Temp/" + "someFile_" + (int)(Math.random() * 100) + "txt";
        DataSourceDecorator decorator = new CompressionDecorator(new EncryptionDecorator(new FileDataSource(fileName)));
//        DataSourceDecorator decorator = new EncryptionDecorator(new FileDataSource(fileName));

        decorator.writeData(someString);
        DataSource fileDataSource = new FileDataSource(fileName);
        System.out.println("Input string: " + someString);
        System.out.println("\nFile '" + fileName + "' include string: \n" + fileDataSource.readData());
        System.out.println("\nDecoded string that included in file '" + fileName + "': \n" + decorator.readData());
    }
}
