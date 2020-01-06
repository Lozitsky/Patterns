package com.kirilo.patterns.behavioral.memento.editor;

import com.kirilo.patterns.behavioral.memento.commands.Command;
import com.kirilo.patterns.behavioral.memento.history.History;
import com.kirilo.patterns.behavioral.memento.history.Memento;
import com.kirilo.patterns.behavioral.memento.history.MementoHistory;
import com.kirilo.patterns.behavioral.memento.shapes.CompoundShape;
import com.kirilo.patterns.behavioral.memento.shapes.Shape;

import javax.swing.*;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class ShapesEditor extends JComponent implements Editor {
    private static CompoundShape allShapes;
    private EditCanvas canvas;
    private History history;

    public ShapesEditor() {
        canvas = new EditCanvas(this);
        allShapes = new CompoundShape();
        history = new MementoHistory();
    }

    @Override
    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    @Override
    public CompoundShape getShapes() {
        return Optional.ofNullable(allShapes).orElseGet(CompoundShape::new);
    }

    @Override
    public void execute(Command command) {
        history.push(command, new Memento(this));
        command.execute();
    }

    @Override
    public void undo() {
        if (history.undo()) {
            canvas.refresh();
            canvas.repaint();
        }
    }

    @Override
    public void redo() {
        if (history.redo()) {
            canvas.refresh();
            canvas.repaint();
        }
    }

    @Override
    public String backup() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(allShapes);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
//        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        try {
            return URLEncoder.encode(new String(byteArrayOutputStream.toByteArray(), StandardCharsets.ISO_8859_1), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean restore(String state) {
//        byte[] bytes = Base64.getDecoder().decode(state);
        try {
            String decode = URLDecoder.decode(state, "UTF-8");
            byte[] bytes = decode.getBytes(StandardCharsets.ISO_8859_1);

            try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
                allShapes = (CompoundShape) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException occurred.");
                return false;
            } catch (IOException e) {
                System.out.println("IOException occurred.");
                return false;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
