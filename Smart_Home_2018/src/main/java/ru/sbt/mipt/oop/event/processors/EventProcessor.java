package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
}
