package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.action.LightsOffAction;
import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.home.component.Door;
import ru.sbt.mipt.oop.home.component.Room;
import ru.sbt.mipt.oop.home.component.SmartHome;

import static ru.sbt.mipt.oop.event.utilities.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) {
            return;
        }

        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(innerObject -> {
                        if (innerObject instanceof Door) {
                            Door door = (Door) innerObject;
                            if (door.getId().equals(event.getObjectId())) {
                                door.setOpen(false);
                                smartHome.executeAction(new LightsOffAction());
                            }
                        }
                    });
                }
            }
        });
    }
}
