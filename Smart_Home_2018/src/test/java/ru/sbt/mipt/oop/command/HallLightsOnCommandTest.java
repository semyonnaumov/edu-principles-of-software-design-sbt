package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.action.LightsOnAction;
import ru.sbt.mipt.oop.home_components.Room;

import static org.junit.Assert.*;

public class HallLightsOnCommandTest extends CommandTest {

    @Test
    public void execute() {
        Command command = new HallLightsOnCommand(smartHome);
        command.execute();
        initialSmartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(new LightsOnAction());
                }
            }
        });
        assertEquals(smartHome, initialSmartHome);
    }
}