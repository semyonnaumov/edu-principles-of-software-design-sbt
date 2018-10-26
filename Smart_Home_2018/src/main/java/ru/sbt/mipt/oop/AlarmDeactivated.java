package ru.sbt.mipt.oop;

public class AlarmDeactivated extends AlarmState {
    public AlarmDeactivated(Alarm myAlarm) {
        this.myAlarm = myAlarm;
    }

    @Override
    public void activateAlarm(int activationCode) {
        if (activationCode == myAlarm.getActivationCode()) {
            myAlarm.setState(new AlarmActivated(myAlarm));
        }
    }

    @Override
    public void deactivateAlarm(int activationCode) {
        return;
    }

    @Override
    public void invokeAlert() {
        return;
    }

    @Override
    public String toString() {
        return "AlarmDeactivated";
    }
}
