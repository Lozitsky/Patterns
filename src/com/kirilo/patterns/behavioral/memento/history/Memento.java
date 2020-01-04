package com.kirilo.patterns.behavioral.memento.history;

import com.kirilo.patterns.behavioral.memento.editor.Editor;

public class Memento {
    private String backup;
    private Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        backup = editor.backup();
    }

    public boolean restore() {
        return editor.restore(backup);
    }
}
