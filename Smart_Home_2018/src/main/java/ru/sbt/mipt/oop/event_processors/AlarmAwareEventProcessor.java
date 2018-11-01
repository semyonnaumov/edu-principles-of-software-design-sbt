package ru.sbt.mipt.oop.event_processors;

import ru.sbt.mipt.oop.event_utilities.EventProcessor;
import ru.sbt.mipt.oop.event_utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;

import static ru.sbt.mipt.oop.event_utilities.SensorEventType.*;

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
        if (event.getType() == LIGHT_ON ||
            event.getType() == LIGHT_OFF ||
            event.getType() == DOOR_OPEN ||
            event.getType() == DOOR_CLOSED) {
            return true;
        } else {
            return false;
        }
    }
}
