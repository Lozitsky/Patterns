package com.kirilo.patterns.creational.builder.table_builder.builders;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutBuilder implements Builder {
    private JPanel panel;
    private GridBagConstraints constraints;
    private int x, y;

    @Override
    public void setWidthAndHeight(int width, int height) {
        panel = new JPanel();
        constraints = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
    }

    @Override
    public void startRow() {
        x = 0;
        ++y;
    }

    @Override
    public void buildCell(String value) {
        constraints.gridx = x++;
        constraints.gridy = y;
        panel.add(new Label(value), constraints);
    }

    @Override
    public Component getResult() {
        return panel;
    }
}
