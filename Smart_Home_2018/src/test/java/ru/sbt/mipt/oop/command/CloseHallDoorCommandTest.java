package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.home.component.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import java.io.IOException;

import static org.junit.Assert.*;

public class CloseHallDoorCommandTest extends CommandTest {

    @Test
    public void execute() throws IOException {
        String path = "src/test/resources/smart-home-test-hall-door-open-lights-on.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        SmartHome hallDoorOpenLightsOn = smartHomeLoader.loadSmartHome();

        Command command = new CloseHallDoorCommand(hallDoorOpenLightsOn);
        command.execute();
        assertEquals(smartHome, hallDoorOpenLightsOn);
    }
}