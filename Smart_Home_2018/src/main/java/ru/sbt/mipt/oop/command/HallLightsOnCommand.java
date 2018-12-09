package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.action.LightsOnAction;
import ru.sbt.mipt.oop.home.component.Room;
import ru.sbt.mipt.oop.home.component.SmartHome;

public class HallLightsOnCommand implements Command {
    private SmartHome smartHome;

    public HallLightsOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(new LightsOnAction());
                }
            }
        });
        return false;
    }

    @Override
    public CommandType getType() {
        return CommandType.HALL_LIGHTS_ON;
    }
}
