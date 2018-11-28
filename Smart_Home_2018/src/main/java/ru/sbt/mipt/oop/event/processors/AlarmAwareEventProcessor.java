package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.event.utilities.SensorEventType;
import ru.sbt.mipt.oop.home_components.SmartHome;

public class AlarmAwareEventProcessor implements EventProcessor {
    private EventProcessor wrappedEventProcessor;

    public AlarmAwareEventProcessor(EventProcessor wrappedEventProcessor) {
        this.wrappedEventProcessor = wrappedEventProcessor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!(smartHome.getAlarm().isDeactivated())) {
            if (isDoorOrLightEvent(event)) {
                smartHome.getAlarm().invokeAlert();
            }
        } else {
            wrappedEventProcessor.processEvent(smartHome, event);
        }
    }

    private boolean isDoorOrLightEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.LIGHT_ON ||
            event.getType() == SensorEventType.LIGHT_OFF ||
            event.getType() == SensorEventType.DOOR_OPEN ||
            event.getType() == SensorEventType.DOOR_CLOSED) {
            return true;
        } else {
            return false;
        }
    }
}
