package com.kirilo.patterns.creational.factory_method.buttons;

import javax.swing.*;
import java.awt.*;

public class WindowsButton implements Button {
    private JPanel panel;
    private JFrame frame;
    private JButton button;

    public WindowsButton() {
        panel = new JPanel();
        frame = new JFrame();
    }

    @Override
    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JLabel label = new JLabel("Hello World!");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    @Override
    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(e -> {
            frame.setVisible(false);
            System.exit(0);
        });
    }
}
