package com.kirilo.patterns.behavioral.command.commands;

import com.kirilo.patterns.behavioral.command.editor.Clipboard;
import com.kirilo.patterns.behavioral.command.editor.Editor;

import javax.swing.*;

public class CutCommand extends AbstractCommand {
    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        String selectedText = getEditor().getTextArea().getSelectedText();
        if (selectedText == null || selectedText.isEmpty()) {
            return false;
        }
        backup();
        String source = getEditor().getTextArea().getText();
        Clipboard.setClipboard(selectedText);
        getEditor().getTextArea().setText(cutString(source));
        return true;
    }

    private String cutString(String source) {
        JTextArea textArea = getEditor().getTextArea();
        return source.substring(0, textArea.getSelectionStart())
                + source.substring(textArea.getSelectionEnd());
    }
}
