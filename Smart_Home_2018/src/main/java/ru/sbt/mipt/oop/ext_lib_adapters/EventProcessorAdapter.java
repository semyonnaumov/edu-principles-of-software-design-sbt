package ru.sbt.mipt.oop.ext_lib_adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.event_processors.EventProcessor;
import ru.sbt.mipt.oop.event_utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;

import static ru.sbt.mipt.oop.event_utilities.SensorEventType.*;

public class EventProcessorAdapter implements EventHandler {
    SmartHome smartHome;
    EventProcessor eventProcessor;

    public EventProcessorAdapter(SmartHome smartHome, EventProcessor eventProcessor) {
        this.smartHome = smartHome;
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = sensorEventFromCCSensorEvent(event);
        if (sensorEvent == null) {
            // Minor bug!
            // Will print the same message n times where n = # of registered event processors
            System.out.println("Cannot convert API's event to native type of event");
        } else {
            // Minor bug!
            // Will print the same message n times where n = # of registered event processors
            System.out.println("Got event: " + sensorEvent);
            eventProcessor.processEvent(this.smartHome, sensorEvent);
        }
    }

    // API offers: "LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
    // Program-native events: ALARM_ACTIVATE, ALARM_DEACTIVATE, DOOR_CLOSED, DOOR_OPEN, LIGHT_OFF, LIGHT_ON;
    private SensorEvent sensorEventFromCCSensorEvent(CCSensorEvent event) {
        if (event.getEventType().equals("LightIsOn")) return new SensorEvent(LIGHT_ON, event.getObjectId());
        if (event.getEventType().equals("LightIsOff")) return new SensorEvent(LIGHT_OFF, event.getObjectId());
        if (event.getEventType().equals("DoorIsOpen")) return new SensorEvent(DOOR_OPEN, event.getObjectId());
        if (event.getEventType().equals("DoorIsClosed")) return new SensorEvent(DOOR_CLOSED, event.getObjectId());
        else return null;
    }
}
