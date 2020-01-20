package com.kirilo.patterns.creational.builder.table_builder.builders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TableDirector {
    private Builder builder;

    public TableDirector(Builder builder) {
        this.builder = builder;
    }

    public void construct(String filename) {
        try (FileReader in = new FileReader(filename); BufferedReader bufferedReader = new BufferedReader(in)) {
            String line;
            String[] cells;
            if ((line = bufferedReader.readLine()) != null) {
                cells = line.split("\t");
                int width = Integer.parseInt(cells[0]);
                int height = Integer.parseInt(cells[1]);
                builder.setWidthAndHeight(width, height);
            }

            while ((line = bufferedReader.readLine()) != null) {
                cells = line.split("\t");
                for (String cell : cells) {
                    builder.buildCell(cell);
                }
                builder.startRow();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
