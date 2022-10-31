package ru.sbt.mipt.oop.home.component.alarm;

public class AlarmActivatedState extends AlarmState {
    public AlarmActivatedState(Alarm myAlarm) {
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
        } else {
            myAlarm.setState(new AlarmOnAlertState(myAlarm));
        }
    }

    @Override
    public void invokeAlert() {
        myAlarm.setState(new AlarmOnAlertState(myAlarm));
        System.out.println("ALERT! Sending sms.");
    }


    @Override
    public String toString() {
        return "AlarmActivatedState";
    }
}
