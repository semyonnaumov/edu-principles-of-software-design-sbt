package ru.sbt.mipt.oop.home_components.alarm;

public class AlarmDeactivated extends AlarmState {
    public AlarmDeactivated(Alarm myAlarm) {
        this.myAlarm = myAlarm;
    }

    @Override
    public void activateAlarm(Integer activationCode) {
        if (activationCode.equals(myAlarm.getActivationCode())) {
            myAlarm.setState(new AlarmActivated(myAlarm));
        }
    }

    @Override
    public void deactivateAlarm(Integer activationCode) {
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
