package ru.sbt.mipt.oop.command;

public class EmptyCommand implements Command {
    @Override
    public boolean execute() {
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.EMPTY;
    }
}
