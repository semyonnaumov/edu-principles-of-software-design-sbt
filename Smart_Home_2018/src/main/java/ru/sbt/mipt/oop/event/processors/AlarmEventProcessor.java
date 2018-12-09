package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.home.component.SmartHome;

import static ru.sbt.mipt.oop.event.utilities.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.event.utilities.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarm() == null) {
            return;
        }
        if (event.getType() == ALARM_ACTIVATE) {
            smartHome.getAlarm().activateAlarm(Integer.parseInt(event.getObjectId()));
        }
        if (event.getType() == ALARM_DEACTIVATE) {
            smartHome.getAlarm().deactivateAlarm(Integer.parseInt(event.getObjectId()));
        }
    }

    private boolean isAlarmEvent(SensorEvent event) {
        if ((event.getType() == ALARM_ACTIVATE) || (event.getType() == ALARM_DEACTIVATE)) {
            return true;
        } else {
            return false;
        }
    }
}

