package ru.sbt.mipt.oop.event.processors;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import java.io.IOException;

import static org.junit.Assert.*;

public class DoorEventProcessorTest extends EventProcessorTest {
    public DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
    public SmartHome doorsOpen;

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-test-doors-open.json");
        this.doorsOpen = smartHomeLoader.loadSmartHome();
    }

    @Test
    public void processPassiveEvent() {
        for (SensorEvent event : passiveSensorEvents) {
            doorEventProcessor.processEvent(smartHome, event);
        }
        assertEquals(smartHome, initialSmartHome);
    }

    @Test
    public void processActiveEvent() {
        for (SensorEvent event : activeSensorEvents) {
            doorEventProcessor.processEvent(smartHome, event);
        }
        assertEquals(smartHome, doorsOpen);
    }
}