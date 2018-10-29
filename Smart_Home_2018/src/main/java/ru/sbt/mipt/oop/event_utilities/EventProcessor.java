package ru.sbt.mipt.oop.event_utilities;

import ru.sbt.mipt.oop.home_components.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
}
