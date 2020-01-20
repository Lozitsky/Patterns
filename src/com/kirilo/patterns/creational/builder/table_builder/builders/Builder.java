package com.kirilo.patterns.creational.builder.table_builder.builders;

import java.awt.*;

public interface Builder {
    void setWidthAndHeight(int width, int height);

    void startRow();

    void buildCell(String value);

    Component getResult();
}
