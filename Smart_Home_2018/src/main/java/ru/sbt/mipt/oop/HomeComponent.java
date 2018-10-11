package ru.sbt.mipt.oop;

public interface HomeComponent {
    void processIncomingEvent(SensorEvent currentEvent, HomeComponent parent);
}
