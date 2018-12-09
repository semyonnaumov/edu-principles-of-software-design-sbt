package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.home.component.SmartHome;
import ru.sbt.mipt.oop.home.component.alarm.Alarm;
import ru.sbt.mipt.oop.home.component.alarm.AlarmOnAlertState;
import ru.sbt.mipt.oop.home.component.alarm.AlarmState;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import java.io.IOException;

import static org.junit.Assert.*;

public class InvokeAlertAlarmCommandTest extends CommandTest {

    @Test
    public void execute() throws IOException {
        String path = "src/test/resources/smart-home-test.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        SmartHome initialSmartHome = smartHomeLoader.loadSmartHome();
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