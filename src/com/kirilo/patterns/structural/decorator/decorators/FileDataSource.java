package com.kirilo.patterns.structural.decorator.decorators;

import java.io.*;
import java.util.Arrays;

public class FileDataSource implements DataSource {
    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(data.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + name);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Data: " + data);
            e.printStackTrace();
        }
    }

    @Override
    public String readData() {
        File file = new File(name);
        char[] dataBuf = null;
        try (Reader reader = new FileReader(name)) {
            dataBuf = new char[(int) file.length()];
            reader.read(dataBuf);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + name);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Data: " + Arrays.toString(dataBuf));
            e.printStackTrace();
        }
        return new String(dataBuf != null ? dataBuf : new char[0]);
    }
}
