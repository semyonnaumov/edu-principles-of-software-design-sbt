package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.home_components.SmartHome;

public class ActivateAlarmCommand implements Command {
    private SmartHome smartHome;
    Integer activationCode;

    public ActivateAlarmCommand(SmartHome smartHome, Integer activationCode) {
        this.smartHome = smartHome;
        this.activationCode = activationCode;
    }

    @Override
    public boolean execute() {
        smartHome.getAlarm().activateAlarm(activationCode);
        return true;
    }
}
