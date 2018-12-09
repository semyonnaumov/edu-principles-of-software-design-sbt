package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.action.DoorsCloseAction;
import ru.sbt.mipt.oop.action.LightsOffAction;
import ru.sbt.mipt.oop.home.component.Room;
import ru.sbt.mipt.oop.home.component.SmartHome;

public class CloseHallDoorCommand implements Command {
    private SmartHome smartHome;

    public CloseHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {

        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(new DoorsCloseAction());
                }
            }
        });
        smartHome.executeAction(new LightsOffAction());
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.CLOSE_HALL_DOOR;
    }
}
