package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.home_components.SmartHome;

public class InvokeAlertAlarmCommand implements Command {
    private SmartHome smartHome;

    public InvokeAlertAlarmCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        smartHome.getAlarm().invokeAlert();
        return true;
    }
}