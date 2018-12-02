package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.action.LightsOnAction;
import ru.sbt.mipt.oop.home_components.Room;

import static org.junit.Assert.*;

public class HomeLightsOffCommandTest extends CommandTest {

    @Test
    public void execute() {
        Command command = new HomeLightsOffCommand(smartHome);
        smartHome.executeAction(new LightsOnAction());
        command.execute();
        assertEquals(smartHome,initialSmartHome);
    }
}