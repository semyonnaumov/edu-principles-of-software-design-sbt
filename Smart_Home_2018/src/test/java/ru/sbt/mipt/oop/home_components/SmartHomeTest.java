package ru.sbt.mipt.oop.home_components;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class SmartHomeTest {
    private SmartHome firstSmartHome;
    private SmartHome secondSmartHome;
    private SmartHome thirdSmartHome;

    @Before
    public void setUp() throws Exception {
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
        this.firstSmartHome = smartHomeLoader.loadSmartHome();
        this.secondSmartHome = smartHomeLoader.loadSmartHome();

        this.thirdSmartHome = smartHomeLoader.loadSmartHome();
        ArrayList<Light> lights = new ArrayList<Light>();
        ArrayList<Door> doors = new ArrayList<Door>();
        lights.add(new Light("8", true));
        doors.add(new Door(false, "15"));
        Room room = new Room(lights, doors, "Closet");
        thirdSmartHome.addRoom(room);
    }

    @Test
    public void equals() {
        assertEquals(firstSmartHome, secondSmartHome);
        assertFalse(firstSmartHome.equals(thirdSmartHome));
    }

    @Test
    public void countRooms() {
        assertEquals(countRooms(firstSmartHome), 4);
        assertEquals(countRooms(thirdSmartHome), 5);
    }

    @Test
    public void countLights() {
        assertEquals(countLights(firstSmartHome),9);
        assertEquals(countLights(thirdSmartHome), 10);
    }

    @Test
    public void countDoors() {
        assertEquals(countDoors(firstSmartHome),4);
        assertEquals(countDoors(thirdSmartHome), 5);
    }

    private int countRooms(SmartHome smartHome) {
        AtomicInteger roomCounter = new AtomicInteger();
        smartHome.executeAction(object -> {
            if(object instanceof Room) {
                roomCounter.addAndGet(1);
            }
        });
        return roomCounter.get();
    }

    private int countLights(SmartHome smartHome) {
        AtomicInteger roomCounter = new AtomicInteger();
        smartHome.executeAction(object -> {
            if(object instanceof Light) {
                roomCounter.addAndGet(1);
            }
        });
        return roomCounter.get();
    }

    private int countDoors(SmartHome smartHome) {
        AtomicInteger roomCounter = new AtomicInteger();
        smartHome.executeAction(object -> {
            if(object instanceof Door) {
                roomCounter.addAndGet(1);
            }
        });
        return roomCounter.get();
    }
}