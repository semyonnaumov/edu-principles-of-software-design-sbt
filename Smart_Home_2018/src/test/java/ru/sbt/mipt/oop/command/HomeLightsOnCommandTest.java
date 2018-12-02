package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.action.LightsOnAction;

import static org.junit.Assert.*;

public class HomeLightsOnCommandTest extends CommandTest {

    @Test
    public void execute() {
        Command command = new HomeLightsOnCommand(smartHome);
        initialSmartHome.executeAction(new LightsOnAction());
        command.execute();
        assertEquals(smartHome,initialSmartHome);
    }
}