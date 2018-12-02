package ru.sbt.mipt.oop.home_components.alarm;

public class AlarmOnAlertState extends AlarmState {
    public AlarmOnAlertState(Alarm myAlarm) {
        this.myAlarm = myAlarm;
    }

    @Override
    public void activateAlarm(Integer activationCode) {
        return;
    }

    @Override
    public void deactivateAlarm(Integer activationCode) {
        if (activationCode.equals(myAlarm.getActivationCode())) {
            myAlarm.setState(new AlarmDeactivatedState(myAlarm));
        }
    }

    @Override
    public void invokeAlert() {
        System.out.println("ALERT! Sending sms.");
    }

    @Override
    public String toString() {
        return "AlarmOnAlertState";
    }
}
