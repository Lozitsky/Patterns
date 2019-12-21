package com.kirilo.patterns.behavioral.command.commands;

import com.kirilo.patterns.behavioral.command.editor.Editor;

import java.util.Stack;

public abstract class AbstractCommand implements Command {
    private Editor editor;
    private Stack<String> backup = new Stack<>();

    public AbstractCommand(Editor editor) {
        this.editor = editor;
    }

    public Editor getEditor() {
        return editor;
    }

    @Override
    public void backup() {
        backup.push(editor.getTextArea().getText());
    }

    @Override
    public void undo() {
        editor.getTextArea().setText(backup.pop());

    }

    @Override
    public abstract boolean execute();
}
