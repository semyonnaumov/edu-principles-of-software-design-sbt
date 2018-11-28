package ru.sbt.mipt.oop.home_components;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.ActionExecutor;
import ru.sbt.mipt.oop.home_components.alarm.Alarm;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements ActionExecutor {
    private Collection<Room> rooms;
    private Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof SmartHome) {
            SmartHome other = (SmartHome) object;
            Collection<Room> otherRooms = other.getRooms();
            for (Room otherRoom : otherRooms) {
                if (!rooms.contains(otherRoom)) {
                    return false;
                }
            }
            return true;
        }
        return  false;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    @Override
    public String toString() {
        return "SmartHome{" +
                "rooms=" + rooms +
                ", alarm=" + alarm +
                '}';
    }
}
