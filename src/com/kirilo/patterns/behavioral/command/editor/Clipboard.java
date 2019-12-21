package com.kirilo.patterns.behavioral.command.editor;

public class Clipboard {
    private static String clipboard;

    public static String getClipboard() {
        return clipboard;
    }

    public static void setClipboard(String clipboard) {
        Clipboard.clipboard = clipboard;
    }
}
