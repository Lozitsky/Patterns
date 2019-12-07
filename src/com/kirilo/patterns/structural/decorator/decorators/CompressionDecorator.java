package com.kirilo.patterns.structural.decorator.decorators;

import java.io.*;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {
    private int compLevel = 6;

    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    public int getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(int compLevel) {
        this.compLevel = compLevel;
    }

    private String compress(String data) {
        byte[] bytes = data.getBytes();

        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(512)) {
            try (OutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel))) {
                dos.write(bytes);
            }
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String decompress(String data) {
        byte[] bytes = Base64.getDecoder().decode(data);
        try (InputStream in = new ByteArrayInputStream(bytes);
             InputStream iin = new InflaterInputStream(in);
             ByteArrayOutputStream bout = new ByteArrayOutputStream(512)) {
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            return new String(bout.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
