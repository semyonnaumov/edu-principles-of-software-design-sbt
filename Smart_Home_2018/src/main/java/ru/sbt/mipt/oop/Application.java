package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.remote_control.RemoteControlRegistry;
import ru.sbt.mipt.oop.controls.remote.RemoteControl;
import ru.sbt.mipt.oop.controls.remote.StandardRemoteControl;
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
    private static RemoteControlRegistry remoteControlRegistry;

    public Application(SmartHomeLoader smartHomeLoader, EventManager eventManager,
                       RemoteControlRegistry remoteControlRegistry) {
        this.smartHomeLoader = smartHomeLoader;
        this.eventManager = eventManager;
        this.remoteControlRegistry = remoteControlRegistry;
    }

    public static void main(String... args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("configuration.xml");

        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        smartHome.setAlarm(new Alarm(12345));
        RemoteControl rc1 = new StandardRemoteControl(1);
        RemoteControl rc2 = new StandardRemoteControl(2);

        remoteControlRegistry.registerRemoteControl(rc1, rc1.getID().toString());
        remoteControlRegistry.registerRemoteControl(rc2, rc2.getID().toString());

        eventManager.setSmartHome(smartHome);
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new LightsEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new DoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new HallDoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmEventProcessor());

        eventManager.runEventsCycle();
    }
}
