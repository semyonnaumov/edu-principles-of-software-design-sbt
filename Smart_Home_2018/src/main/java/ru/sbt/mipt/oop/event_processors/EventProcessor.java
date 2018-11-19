package ru.sbt.mipt.oop.event_processors;

import ru.sbt.mipt.oop.event_utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
}
