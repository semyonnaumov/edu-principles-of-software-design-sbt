package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.event_utilities.EventProcessor;
import ru.sbt.mipt.oop.event_utilities.SensorEvent;
import ru.sbt.mipt.oop.event_utilities.SensorEventProvider;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_utilities.HomeEventManager;

import static ru.sbt.mipt.oop.event_utilities.SensorEventType.*;

public class CCSensorEventManagerAdapter extends HomeEventManager {
    private SensorEventsManager sensorEventsManager;

    public CCSensorEventManagerAdapter(SmartHome smartHome,
                                       SensorEventProvider sensorEventProvider,
                                       SensorEventsManager sensorEventsManager) {
        super(smartHome, sensorEventProvider);
        this.sensorEventsManager = sensorEventsManager;
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        sensorEventsManager.registerEventHandler(event -> {
            SensorEvent sensorEvent = sensorEventFromCCSensorEvent(event);
            if (sensorEvent == null) {
                return;
            }
            eventProcessor.processEvent(this.smartHome, sensorEvent);
        });
    }

    @Override
    public void deleteEventProcessor(EventProcessor eventProcessor) {
        System.out.println("Cannot delete an event processor using the Cool Company API");
    }

    @Override
    public void runEventsCycle() {
        sensorEventsManager.start();
    }

    // API offers: "LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
    // We can work with: ALARM_ACTIVATE, ALARM_DEACTIVATE, DOOR_CLOSED, DOOR_OPEN, LIGHT_OFF, LIGHT_ON;
    private SensorEvent sensorEventFromCCSensorEvent(CCSensorEvent event) {
        if (event.getEventType().equals("LightIsOn")) return new SensorEvent(LIGHT_ON, event.getObjectId());
        if (event.getEventType().equals("LightIsOff")) return new SensorEvent(LIGHT_OFF, event.getObjectId());
        if (event.getEventType().equals("DoorIsOpen")) return new SensorEvent(DOOR_OPEN, event.getObjectId());
        if (event.getEventType().equals("DoorIsClosed")) return new SensorEvent(DOOR_CLOSED, event.getObjectId());
        return null; //Cannot convert API's event to our type of event
    }

}
