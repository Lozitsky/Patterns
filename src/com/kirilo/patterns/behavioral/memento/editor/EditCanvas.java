package com.kirilo.patterns.behavioral.memento.editor;

import com.kirilo.patterns.behavioral.memento.commands.ColorCommand;
import com.kirilo.patterns.behavioral.memento.commands.MoveCommand;
import com.kirilo.patterns.behavioral.memento.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class EditCanvas extends Canvas {
    private static final int PADDING = 10;
    private Editor editor;
    private JFrame frame;

    EditCanvas(Editor editor) {
        this.editor = editor;
        createFrame();
        attachKeyboardListeners();
        attachMouseListeners();
        refresh();
    }

    private void attachMouseListeners() {
        MouseAdapter colorizeMouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON3) {
                    return;
                }
                Shape shape = editor.getShapes().getChildAt(e.getX(), e.getY());
                if (shape != null) {
                    editor.getShapes().unSelect();
                    shape.select();
                    editor.execute(new ColorCommand(editor, new Color((int) (Math.random() * 0x1000000))));
                    repaint();
                }
            }
        };
        addMouseListener(colorizeMouseAdapter);

        MouseAdapter selectMouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1) {
                    return;
                }
                Shape shape = editor.getShapes().getChildAt(e.getX(), e.getY());
                boolean ctrl = (e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK;
                if (shape == null) {
                    if (!ctrl) {
                        editor.getShapes().unSelect();
                    }
                } else if (ctrl) {
                    shape.toggle();
                } else {
                    if (!shape.isSelected()) {
                        editor.getShapes().unSelect();
                    }
                    shape.select();
                }
                repaint();
            }
        };
        addMouseListener(selectMouseAdapter);

        MouseAdapter dragMouseAdapter = new MouseAdapter() {
            MoveCommand moveCommand;

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1 || moveCommand == null) {
                    return;
                }
                moveCommand.stop(e.getX(), e.getY());
                editor.execute(moveCommand);
                moveCommand = null;
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != MouseEvent.BUTTON1_DOWN_MASK) {
                    return;
                }
                if (moveCommand == null) {
                    moveCommand = new MoveCommand(editor);
                    moveCommand.start(e.getX(), e.getY());
                } else {
                    moveCommand.move(e.getX(), e.getY());
                }
                repaint();
            }
        };
        addMouseListener(dragMouseAdapter);
        addMouseMotionListener(dragMouseAdapter);
    }

    private void attachKeyboardListeners() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_Z:
                            editor.undo();
                            break;
                        case KeyEvent.VK_R:
                            editor.redo();
                            break;
                    }
                }
            }
        });
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        Border emptyBorder = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
        panel.setBorder(emptyBorder);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setContentPane(panel);

        panel.add(new JLabel("Select and drag to move."), BorderLayout.PAGE_END);
        panel.add(new JLabel("Right click to change color."), BorderLayout.PAGE_END);
        panel.add(new JLabel("Undo: Ctrl+Z, Redo: Ctrl+R."), BorderLayout.PAGE_END);
        panel.add(this);
        frame.setVisible(true);
        panel.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.clearRect(0, 0, getWidth(), getHeight());

        editor.getShapes().paint(bufferedImage.getGraphics());
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void clear() {
        super.getGraphics().clearRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public int getWidth() {
        return editor.getShapes().getX() + (int) (editor.getShapes().getWidth() * 1.5);
    }

    @Override
    public int getHeight() {
        return editor.getShapes().getY() + (int) (editor.getShapes().getHeight() * 1.5);
    }

    public void refresh() {
        setSize(getWidth(), getHeight());
        frame.pack();
    }
}
