package ru.sbt.mipt.oop;

public class AlarmOnAlert extends AlarmState {
    public AlarmOnAlert(Alarm myAlarm) {
        this.myAlarm = myAlarm;
    }

    @Override
    public void activateAlarm(int activationCode) {
        return;
    }

    @Override
    public void deactivateAlarm(int activationCode) {
        if (activationCode == myAlarm.getActivationCode()) {
            myAlarm.setState(new AlarmDeactivated(myAlarm));
        }
    }

    @Override
    public void invokeAlert() {
        return;
    }

    @Override
    public String toString() {
        return "AlarmOnAlert";
    }
}
