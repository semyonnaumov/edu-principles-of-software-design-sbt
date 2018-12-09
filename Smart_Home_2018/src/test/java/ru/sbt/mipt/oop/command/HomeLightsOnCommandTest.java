package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.home.component.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import java.io.IOException;

import static org.junit.Assert.*;

public class HomeLightsOnCommandTest extends CommandTest {

    @Test
    public void execute() throws IOException {
        String path = "src/test/resources/smart-home-test-lights-on.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        SmartHome lightsOn = smartHomeLoader.loadSmartHome();

        Command command = new HomeLightsOnCommand(smartHome);
        command.execute();
        assertEquals(smartHome,lightsOn);
    }
}