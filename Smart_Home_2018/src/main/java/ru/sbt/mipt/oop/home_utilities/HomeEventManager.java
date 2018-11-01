package ru.sbt.mipt.oop.home_utilities;

import ru.sbt.mipt.oop.event_utilities.EventProcessor;
import ru.sbt.mipt.oop.event_utilities.SensorEvent;
import ru.sbt.mipt.oop.event_utilities.SensorEventProvider;
import ru.sbt.mipt.oop.home_components.SmartHome;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implements pattern "Observer"
 * Contains event listeners aka EventProcessors
 * When an event occurs it notifies all listeners
 */
public class HomeEventManager {
    private Collection<EventProcessor> eventProcessors = new ArrayList<EventProcessor>();
    protected SmartHome smartHome;
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
