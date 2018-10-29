package ru.sbt.mipt.oop.home_components.alarm;

import ru.sbt.mipt.oop.action_utilities.Action;
import ru.sbt.mipt.oop.action_utilities.ActionExecutor;

public class Alarm implements ActionExecutor {
    private final Integer activationCode;
    private AlarmState state = new AlarmDeactivated(this);

    public Alarm(Integer activationCode) {
        this.activationCode = activationCode;
    }

    public void activateAlarm(Integer activationCode) {
        state.activateAlarm(activationCode);
    }

    public void deactivateAlarm(Integer activationCode) {
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

    public Integer getActivationCode() {
        return activationCode;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "activationCode=" + activationCode +
                ", state=" + state +
                '}';
    }

    public AlarmState getState() {
        return this.state;
    }

    public boolean isDeactivated() {
        return state instanceof AlarmDeactivated;
    }
}