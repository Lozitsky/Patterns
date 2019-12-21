package com.kirilo.patterns.behavioral.command.commands;

import com.kirilo.patterns.behavioral.command.editor.Clipboard;
import com.kirilo.patterns.behavioral.command.editor.Editor;

public class PasteCommand extends AbstractCommand {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (Clipboard.getClipboard() == null || Clipboard.getClipboard().isEmpty()) {
            return false;
        }
        backup();
        getEditor().getTextArea().insert(Clipboard.getClipboard(), getEditor().getTextArea().getCaretPosition());
        return true;
    }
}
