package com.kirilo.patterns.creational.builder.table_builder.builders;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class JTableBuilder implements Builder {
    private JTable table;
    private TableModel model;
    private int x, y;

    @Override
    public void setWidthAndHeight(int width, int height) {
        table = new JTable(height, width);
        model = table.getModel();
    }

    @Override
    public void startRow() {
        x = 0;
        ++y;
    }

    @Override
    public void buildCell(String value) {
        model.setValueAt(value, y, x++);
    }

    @Override
    public Component getResult() {
        return table;
    }
}
