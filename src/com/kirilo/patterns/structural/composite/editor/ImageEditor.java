package com.kirilo.patterns.structural.composite.editor;

import com.kirilo.patterns.structural.composite.shapes.CompoundShape;
import com.kirilo.patterns.structural.composite.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageEditor {
    private EditorCanvas canvas;
    private CompoundShape shapes = new CompoundShape();

    public ImageEditor() {
        canvas = new EditorCanvas();
    }

    public void loadShapes(Shape... shapes) {
        this.shapes.clear();
        this.shapes.add(shapes);
        canvas.refresh();
    }

    private class EditorCanvas extends Canvas {
        private static final int PADDING = 10;
        private JFrame frame;

        private EditorCanvas() {
            createFrame();
            refresh();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    shapes.unselect();
                    shapes.selectChildAt(e.getX(), e.getY());
                    e.getComponent().repaint();
                }
            });
        }

        private void createFrame() {
            frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            Border border = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
            panel.setBorder(border);
            frame.setContentPane(panel);

            frame.add(this);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public int getWidth() {
            return shapes.getX() + shapes.getWidth() + PADDING;
        }

        @Override
        public int getHeight() {
            return shapes.getY() + shapes.getHeight() + PADDING;
        }

        private void refresh() {
            setSize(getWidth(), getHeight());
            frame.pack();
        }

        @Override
        public void paint(Graphics graphics) {
            shapes.paint(graphics);
        }

    }
}
