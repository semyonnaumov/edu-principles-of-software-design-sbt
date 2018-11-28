package ru.sbt.mipt.oop.command;

public class EmptyCommand implements Command {
    @Override
    public boolean execute() {
        return true;
    }
}
