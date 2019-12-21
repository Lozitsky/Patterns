package com.kirilo.patterns.behavioral.command.commands;

import com.kirilo.patterns.behavioral.command.editor.Clipboard;
import com.kirilo.patterns.behavioral.command.editor.Editor;

public class CopyCommand extends AbstractCommand {
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        Clipboard.setClipboard(getEditor().getTextArea().getSelectedText());
        return false;
    }
}
