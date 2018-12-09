package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.action.LightsOffAction;
import ru.sbt.mipt.oop.home.component.SmartHome;

public class HomeLightsOffCommand implements Command {
    private SmartHome smartHome;

    public HomeLightsOffCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        smartHome.executeAction(new LightsOffAction());
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.HOME_LIGHTS_OFF;
    }
}
