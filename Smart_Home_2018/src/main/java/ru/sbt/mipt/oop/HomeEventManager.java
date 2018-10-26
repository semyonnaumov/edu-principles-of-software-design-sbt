package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implements pattern "Observer"
 * Contains event listeners aka EventProcessors
 * When an event occurs it notifies all listeners
 */
public class HomeEventManager {
    private Collection<EventProcessor> eventProcessors = new ArrayList<EventProcessor>();
    private SmartHome smartHome;
    private SensorEventProvider sensorEventProvider;

    public HomeEventManager(SmartHome smartHome, SensorEventProvider sensorEventProvider){
        this.smartHome = smartHome;
        this.sensorEventProvider =sensorEventProvider;
    }

    public void registerEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    public void deleteEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.remove(eventProcessor);
    }

    public void runEventsCycle() {
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event :" + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = sensorEventProvider.getNextSensorEvent();
        }
    }
}
