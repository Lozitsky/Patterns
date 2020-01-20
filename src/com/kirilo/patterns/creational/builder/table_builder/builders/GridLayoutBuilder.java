package com.kirilo.patterns.creational.builder.table_builder.builders;

import javax.swing.*;
import java.awt.*;

public class GridLayoutBuilder implements Builder {
    private JPanel panel;

    @Override
    public void setWidthAndHeight(int width, int height) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(height, width));
        panel.setBackground(Color.WHITE);
    }

    @Override
    public void startRow() {

    }

    @Override
    public void buildCell(String value) {
        panel.add(new Label(value));
    }

    @Override
    public Component getResult() {
        return panel;
    }
}
