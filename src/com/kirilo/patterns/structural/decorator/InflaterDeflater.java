package com.kirilo.patterns.structural.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class InflaterDeflater {
    public static void main(String[] args) {
        try {
            // Encode a String into bytes
            String inputString = "blahblahblah??";
            byte[] input = inputString.getBytes("UTF-8");

            // Compress the bytes
            byte[] output = new byte[100];
            Deflater compresser = new Deflater();
            compresser.setInput(input);
            compresser.finish();
            int compressedDataLength = compresser.deflate(output);
            //-------------------------------------------------------------------------------
            System.out.println(Arrays.toString(output));
            System.out.println(new String(output));
            String encode = URLEncoder.encode(new String(output, "ISO-8859-1"), "UTF-8");
            System.out.println("Encode: " + encode);
            String decode = URLDecoder.decode(encode, "UTF-8");
            System.out.println(decode);
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ByteArrayInputStream in = new ByteArrayInputStream(decode.getBytes("ISO-8859-1"));
                InflaterInputStream inputStream = new InflaterInputStream(in);

                int b;
                while ((b = inputStream.read()) != -1) {
                    out.write(b);
                }
                in.close();
                inputStream.close();
                out.close();
                System.out.println("Out: " + new String(out.toByteArray()));
            } catch (IOException ex) {
//                return null;
            }

            //-------------------------------------------------------------------------------

            // Decompress the bytes
            Inflater decompresser = new Inflater();
            decompresser.setInput(output, 0, compressedDataLength);
            byte[] result = new byte[100];
            int resultLength = decompresser.inflate(result);
            decompresser.end();

            // Decode the bytes into a String
            String outputString = new String(result, 0, resultLength, "UTF-8");
            System.out.println(outputString);
        } catch (java.io.UnsupportedEncodingException ex) {
            // handle
        } catch (java.util.zip.DataFormatException ex) {
            // handle
        }
    }
}
