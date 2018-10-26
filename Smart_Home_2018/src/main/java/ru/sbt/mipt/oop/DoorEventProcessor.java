package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (isDoorEvent(event)) {
            smartHome.executeAction(object -> {
                if (object instanceof Door) {
                    Door door = (Door) object;
                    if (event.getObjectId().equals(door.getId())){
                        if (event.getType() == DOOR_OPEN) {
                            door.setOpen(true);
                        }
                        if (event.getType() == DOOR_CLOSED) {
                            door.setOpen(false);
                        }
                    }
                }
            });
        }
    }

    private boolean isDoorEvent(SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            return true;
        } else {
            return false;
        }
    }
}
