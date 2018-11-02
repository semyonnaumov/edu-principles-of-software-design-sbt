package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.event_processors.*;
import ru.sbt.mipt.oop.event_utilities.RandomSensorEventProvider;
import ru.sbt.mipt.oop.event_utilities.SensorEventProvider;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_components.alarm.Alarm;
import ru.sbt.mipt.oop.home_utilities.FileSmartHomeLoader;
import ru.sbt.mipt.oop.home_utilities.HomeEventManager;
import ru.sbt.mipt.oop.home_utilities.SmartHomeLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader;
    private static SensorEventsManager sensorEventsManager;

    public Application(SmartHomeLoader smartHomeLoader, SensorEventsManager sensorEventsManager) {
        this.smartHomeLoader = smartHomeLoader;
        this.sensorEventsManager = sensorEventsManager;
    }

    public static void main(String... args) throws IOException {

        // Uncomment for spring usage:
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        SensorEventsManager sensorEventsManager = (SensorEventsManager) ctx.getBean("sensorEventsManager");

        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        smartHome.setAlarm(new Alarm(12345));
        SensorEventProvider sensorEventProvider = new RandomSensorEventProvider();

        // Старый EventManager, до добавления адаптера
        //HomeEventManager eventManager = new HomeEventManager(smartHome, sensorEventProvider);

        // Закомментирован адаптер, используемый до spring
        //SensorEventsManager sensorEventsManager = new SensorEventsManager();

        HomeEventManager eventManager = new CCSensorEventManagerAdapter(smartHome,
                sensorEventProvider, sensorEventsManager);

        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new LightsEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new DoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new HallDoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmEventProcessor());

        eventManager.runEventsCycle();
    }
}
