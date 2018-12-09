package ru.sbt.mipt.oop.controls.remote;

import ru.sbt.mipt.oop.command.Command;
import ru.sbt.mipt.oop.command.EmptyCommand;

public class Button {
    private final String iD;
    private Command command;

    public String getiD() {
        return iD;
    }

    public Command getCommand() {
        return command;
    }

    public Button(String iD, Command command) {
        this.iD = iD;
        this.command = command;
    }

    public Button(String iD) {
        this.iD = iD;
        this.command = new EmptyCommand();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onPressed() {
        command.execute();
    }
}
