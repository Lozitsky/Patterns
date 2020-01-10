package com.kirilo.patterns.behavioral.state.ui;

import javax.swing.*;
import java.awt.*;

public class UI {
    private Player player;
    private JTextField textField;

    public UI(Player player) {
        this.player = player;
        textField = new JTextField();
    }

    public void init() {
        JFrame frame = new JFrame("Player Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(textField);
        panel.add(buttons);

        JButton play = new JButton("Play");
        play.addActionListener(e -> textField.setText(player.getState().onPlay()));

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> textField.setText(player.getState().onLock()));

        JButton next = new JButton("Next");
        next.addActionListener(e -> textField.setText(player.getState().onNext()));

        JButton prev = new JButton("Prev");
        prev.addActionListener(e -> textField.setText(player.getState().onPrevious()));
        frame.setVisible(true);
        frame.setSize(300, 100);
        buttons.add(play);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(prev);
    }
}
