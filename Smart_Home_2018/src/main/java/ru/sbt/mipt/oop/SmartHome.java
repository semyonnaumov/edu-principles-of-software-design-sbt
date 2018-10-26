package ru.sbt.mipt.oop;

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

    @Override
    public void executeAction(Action action) {
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }

    @Override
    public String toString() {
        return "SmartHome{" +
                "alarm=" + alarm +
                '}';
    }
}
