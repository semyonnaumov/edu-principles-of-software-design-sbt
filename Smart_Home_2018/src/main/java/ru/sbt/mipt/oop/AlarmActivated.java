package ru.sbt.mipt.oop;

public class AlarmActivated extends AlarmState {
    public AlarmActivated(Alarm myAlarm) {
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
        } else {
            myAlarm.setState(new AlarmOnAlert(myAlarm));
        }
    }

    @Override
    public void invokeAlert() {
        myAlarm.setState(new AlarmOnAlert(myAlarm));
    }


    @Override
    public String toString() {
        return "AlarmActivated";
    }
}
