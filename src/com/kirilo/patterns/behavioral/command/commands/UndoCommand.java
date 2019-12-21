package com.kirilo.patterns.behavioral.command.commands;

import com.kirilo.patterns.behavioral.command.editor.Editor;

public class UndoCommand extends AbstractCommand {

    public UndoCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (!CommandHistory.isEmpty()) {
            Command command = CommandHistory.pop();
            if (command != null) {
                command.undo();
            }
        }
        return false;
    }
}
