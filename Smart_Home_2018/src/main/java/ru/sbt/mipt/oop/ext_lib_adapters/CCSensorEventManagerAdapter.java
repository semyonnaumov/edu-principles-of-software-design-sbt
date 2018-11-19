package ru.sbt.mipt.oop.ext_lib_adapters;

import com.coolcompany.smarthome.events.*;
import ru.sbt.mipt.oop.event_processors.EventProcessor;
import ru.sbt.mipt.oop.event_utilities.EventManager;

public class CCSensorEventManagerAdapter extends EventManager {
    private SensorEventsManager sensorEventsManager;

    public CCSensorEventManagerAdapter(SensorEventsManager sensorEventsManager) {
        this.sensorEventsManager = sensorEventsManager;
    }

    @Override
    public void runEventsCycle() {
        sensorEventsManager.start();
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        EventHandler eventProcessorAdapter = new EventProcessorAdapter(this.smartHome, eventProcessor);
        sensorEventsManager.registerEventHandler(eventProcessorAdapter);
    }

    @Override
    public void deleteEventProcessor(EventProcessor eventProcessor) {
        System.out.println("This event manager does not support deletion of event processors.\n" +
                "Nothing was deleted.");
    }
}
