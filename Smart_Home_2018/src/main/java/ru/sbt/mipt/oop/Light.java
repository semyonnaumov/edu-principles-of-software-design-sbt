package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class Light implements HomeComponent {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void processIncomingEvent(SensorEvent currentEvent, HomeComponent parent) {
        // check if current light needs to be processed
        if (id.equals(currentEvent.getObjectId())) {
            if (currentEvent.getType() == LIGHT_ON) {
                isOn = true;
                System.out.println("Light " + id + " in room " + ((Room)parent).getName() + " was turned on.");
            } else {
                isOn = false;
                System.out.println("Light " + id + " in room " + ((Room)parent).getName() + " was turned off.");
            }
        }
    }
}
