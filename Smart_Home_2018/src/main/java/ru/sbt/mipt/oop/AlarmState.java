package ru.sbt.mipt.oop;

public abstract class AlarmState {
    protected Alarm myAlarm;
    public abstract void activateAlarm(int activationCode);
    public abstract void deactivateAlarm(int activationCode);
    public abstract void invokeAlert();
}
