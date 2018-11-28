package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.processors.*;
import ru.sbt.mipt.oop.event.utilities.EventManager;
import ru.sbt.mipt.oop.home_components.*;
import ru.sbt.mipt.oop.home_components.alarm.Alarm;
import ru.sbt.mipt.oop.loaders.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader;
    private static EventManager eventManager;

    public Application(SmartHomeLoader smartHomeLoader, EventManager eventManager) {
        this.smartHomeLoader = smartHomeLoader;
        this.eventManager = eventManager;
    }

    public static void main(String... args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("configuration.xml");

        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        smartHome.setAlarm(new Alarm(12345));
        eventManager.setSmartHome(smartHome);

        // Should be done via Spring?
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new LightsEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new DoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new HallDoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmEventProcessor());

        eventManager.runEventsCycle();
    }
}
