package com.kirilo.patterns.structural.decorator.decorators;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

//https://docs.oracle.com/javase/8/docs/api/java/util/zip/Inflater.html
//https://stackoverflow.com/questions/16351668/compression-and-decompression-of-string-data-in-java
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
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(512)) {
            try (OutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel))) {
                dos.write(bytes);
            }
            return URLEncoder.encode(new String(bout.toByteArray(), "ISO-8859-1"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String decompress(String data) {
        try {
            String decode = URLDecoder.decode(data, "UTF-8");
            try (ByteArrayOutputStream out = new ByteArrayOutputStream(512)) {
                try (
                        ByteArrayInputStream in = new ByteArrayInputStream(decode.getBytes("ISO-8859-1"));
                        InflaterInputStream inputStream = new InflaterInputStream(in)
                ) {
/*                    int b;
                    while ((b = inputStream.read()) != -1) {
                        out.write(b);
                    }*/
                    for (int b = inputStream.read(); b != -1; b = inputStream.read()) {
                        out.write(b);
                    }
                    out.close();
                }
                return new String(out.toByteArray());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
