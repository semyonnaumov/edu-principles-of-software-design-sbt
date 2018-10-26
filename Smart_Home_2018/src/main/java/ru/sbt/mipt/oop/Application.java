package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();

    public static void main(String... args) throws IOException {
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        SensorEventProvider sensorEventProvider = new RandomSensorEventProvider();
        HomeEventManager eventManager = new HomeEventManager(smartHome, sensorEventProvider);
        eventManager.registerEventProcessor(new LightsEventProcessor());
        eventManager.registerEventProcessor(new DoorEventProcessor());
        eventManager.registerEventProcessor(new HallDoorEventProcessor());

        eventManager.runEventsCycle();
    }
}
