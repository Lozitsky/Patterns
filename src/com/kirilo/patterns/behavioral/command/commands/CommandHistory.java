package com.kirilo.patterns.behavioral.command.commands;

import java.util.Stack;

public class CommandHistory {
    private static Stack<Command> commands = new Stack<>();

    public static void push(Command command) {
        commands.push(command);
    }

    public static Command pop() {
        return commands.pop();
    }

    public static boolean isEmpty() {
        return commands.isEmpty();
    }
}
