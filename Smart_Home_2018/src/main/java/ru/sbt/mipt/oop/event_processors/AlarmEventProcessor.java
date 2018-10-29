package ru.sbt.mipt.oop.event_processors;

import ru.sbt.mipt.oop.event_utilities.EventProcessor;
import ru.sbt.mipt.oop.event_utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;

import static ru.sbt.mipt.oop.event_utilities.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.event_utilities.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE) {
            smartHome.getAlarm().activateAlarm(Integer.parseInt(event.getObjectId()));
        }
        if (event.getType() == ALARM_DEACTIVATE) {
            smartHome.getAlarm().deactivateAlarm(Integer.parseInt(event.getObjectId()));
        }
    }
}
