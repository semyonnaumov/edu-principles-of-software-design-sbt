package ru.sbt.mipt.oop.command;

import org.junit.Test;
import ru.sbt.mipt.oop.action.DoorsOpenAction;
import ru.sbt.mipt.oop.home_components.Room;

import static org.junit.Assert.*;

public class CloseHallDoorCommandTest extends CommandTest {

    @Test
    public void execute() {
        Command command = new CloseHallDoorCommand(smartHome);
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName() == "hall") {
                    room.executeAction(new DoorsOpenAction());
                }
            }
        });

        command.execute();
        assertEquals(smartHome, initialSmartHome);
    }
}