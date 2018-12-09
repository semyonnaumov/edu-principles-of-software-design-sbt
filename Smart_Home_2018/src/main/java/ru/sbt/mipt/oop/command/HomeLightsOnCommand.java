package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.action.LightsOnAction;
import ru.sbt.mipt.oop.home.component.SmartHome;

public class HomeLightsOnCommand implements Command {
    private SmartHome smartHome;

    public HomeLightsOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        smartHome.executeAction(new LightsOnAction());
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.HOME_LIGHTS_ON;
    }
}
