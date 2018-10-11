package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements HomeComponent {
    Collection<Room> rooms;

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
    public void processIncomingEvent(SensorEvent currentEvent, HomeComponent parent) {
        // Call this method in all nested HomeComponents
        for (Room room : rooms) {
            room.processIncomingEvent(currentEvent, this);
        }
    }
}
