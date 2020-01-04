package com.kirilo.patterns.behavioral.memento.history;

import com.kirilo.patterns.behavioral.memento.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class MementoHistory implements History {
    private List<Pair> history = new ArrayList<>();
    private int virtualSize = 0;

    @Override
    public void push(Command command, Memento memento) {
        if (virtualSize != history.size() && virtualSize > 0) {
            history = history.subList(0, virtualSize - 1);
        }
        history.add(new Pair(command, memento));
        virtualSize = history.size();
    }

    @Override
    public boolean undo() {
        Pair undoPair = getUndo();
        if (undoPair == null) {
            return false;
        }
        System.out.println("Undoing: " + undoPair.getCommand().getName());
        return undoPair.getMemento().restore();
    }

    @Override
    public boolean redo() {
        Pair redoPair = getRedo();
        if (redoPair == null) {
            return false;
        }
        System.out.println("Redoing: " + redoPair.getCommand().getName());
        return redoPair.getMemento().restore() && redoPair.getCommand().execute();
    }

    private class Pair {
        private Command command;
        private Memento memento;

        public Pair(Command command, Memento memento) {
            this.command = command;
            this.memento = memento;
        }

        public Command getCommand() {
            return command;
        }

        public Memento getMemento() {
            return memento;
        }
    }

    private Pair getUndo() {
        if (virtualSize == 0) {
            return null;
        }
        virtualSize = Math.max(0, virtualSize - 1);
        return history.get(virtualSize);
    }

    private Pair getRedo() {
        if (virtualSize == history.size()) {
            return null;
        }
        virtualSize = Math.min(history.size(), virtualSize + 1);
        return history.get(virtualSize - 1);
    }
}
