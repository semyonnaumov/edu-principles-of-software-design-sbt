package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.home_components.alarm.Alarm;
import ru.sbt.mipt.oop.home_components.alarm.AlarmActivatedState;
import ru.sbt.mipt.oop.home_components.alarm.AlarmOnAlertState;
import ru.sbt.mipt.oop.home_components.alarm.AlarmState;

import static org.junit.Assert.*;

public class InvokeAlertAlarmCommandTest extends CommandTest {

    @Test
    public void execute() {
        Command command = new InvokeAlertAlarmCommand(smartHome);
        assertFalse(command.execute());

        smartHome.setAlarm(new Alarm(12345));
        Alarm alarm = new Alarm(12345);
        AlarmState state = new AlarmOnAlertState(alarm);
        alarm.setState(state);
        initialSmartHome.setAlarm(alarm);

        command.execute();
        assertEquals(initialSmartHome.getAlarm().getState().toString(), smartHome.getAlarm().getState().toString());
    }
}