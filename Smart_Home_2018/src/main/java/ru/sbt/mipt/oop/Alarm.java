package ru.sbt.mipt.oop;

public class Alarm implements ActionExecutor {
    private final int activationCode;
    private AlarmState state = new AlarmDeactivated(this);

    public Alarm(int activationCode) {
        this.activationCode = activationCode;
    }

    public void activateAlarm(int activationCode) {
        state.activateAlarm(activationCode);
    }

    public void deactivateAlarm(int activationCode) {
        state.deactivateAlarm(activationCode);
    }

    public void invokeAlert(){
        state.invokeAlert();
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    public int getActivationCode() {
        return activationCode;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "activationCode=" + activationCode +
                ", state=" + state +
                '}';
    }
}
