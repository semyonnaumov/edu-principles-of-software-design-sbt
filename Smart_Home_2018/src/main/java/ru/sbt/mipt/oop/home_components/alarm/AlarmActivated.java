package ru.sbt.mipt.oop.home_components.alarm;

public class AlarmActivated extends AlarmState {
    public AlarmActivated(Alarm myAlarm) {
        this.myAlarm = myAlarm;
    }

    @Override
    public void activateAlarm(Integer activationCode) {
        return;
    }

    @Override
    public void deactivateAlarm(Integer activationCode) {
        if (activationCode == myAlarm.getActivationCode()) {
            myAlarm.setState(new AlarmDeactivated(myAlarm));
        } else {
            myAlarm.setState(new AlarmOnAlert(myAlarm));
        }
    }

    @Override
    public void invokeAlert() {
        myAlarm.setState(new AlarmOnAlert(myAlarm));
        System.out.println("ALERT! Sending sms.");
    }


    @Override
    public String toString() {
        return "AlarmActivated";
    }
}
