package ru.sbt.mipt.oop.event_processors;

import ru.sbt.mipt.oop.event_utilities.EventProcessor;
import ru.sbt.mipt.oop.event_utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.Door;
import ru.sbt.mipt.oop.home_components.Light;
import ru.sbt.mipt.oop.home_components.Room;
import ru.sbt.mipt.oop.home_components.SmartHome;

import static ru.sbt.mipt.oop.event_utilities.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) {
            return;
        }

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId()) && room.getName().equals("hall")) {
                    turnLightsOff(smartHome);
                }
            }
        }
    }

    private void turnLightsOff(SmartHome smartHome) {
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(false);
            }
        });
    }
}
