package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event_processors.*;
import ru.sbt.mipt.oop.event_utilities.RandomSensorEventProvider;
import ru.sbt.mipt.oop.event_utilities.SensorEventProvider;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_utilities.FileSmartHomeLoader;
import ru.sbt.mipt.oop.home_utilities.HomeEventManager;
import ru.sbt.mipt.oop.home_utilities.SmartHomeLoader;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();

    public static void main(String... args) throws IOException {
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        SensorEventProvider sensorEventProvider = new RandomSensorEventProvider();
        HomeEventManager eventManager = new HomeEventManager(smartHome, sensorEventProvider);
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new LightsEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new DoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new HallDoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmEventProcessor());

        eventManager.runEventsCycle();
    }
}
