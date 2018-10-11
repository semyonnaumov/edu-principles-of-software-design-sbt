package ru.sbt.mipt.oop;

import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;


public class Room implements HomeComponent {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void processIncomingEvent(SensorEvent currentEvent, HomeComponent parent) {
        /* We can get rid of these two "if's" if in future we want to add more components like "door" and "light"
         without changing the code here. For this purpose, it's needed to put all things that a room has into
         one collection, containing HomeComponents*/

        // If we need to control lights
        if (currentEvent.getType() == LIGHT_OFF || currentEvent.getType() == LIGHT_ON) {
            for (Light light : lights) {
                light.processIncomingEvent(currentEvent, this);
            }
        }
        // If we need to control doors
        if (currentEvent.getType() == DOOR_CLOSED || currentEvent.getType() == DOOR_OPEN) {
            for (Door door : doors) {
                door.processIncomingEvent(currentEvent, this);
            }
        }
    }
}
