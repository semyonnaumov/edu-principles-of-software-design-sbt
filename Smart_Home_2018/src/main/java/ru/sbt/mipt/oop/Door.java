package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class Door implements HomeComponent {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void processIncomingEvent(SensorEvent currentEvent, HomeComponent parent) {
        // check if current door needed to be processed
        if (id.equals(currentEvent.getObjectId())) {
            if (currentEvent.getType() == DOOR_OPEN) {
                isOpen = true;
                System.out.println("Door " + id + " in room " + ((Room)parent).getName() + " was opened.");
            } else {
                isOpen = false;
                System.out.println("Door " + id + " in room " + ((Room)parent).getName() + " was closed.");
            }
        }
    }
}
