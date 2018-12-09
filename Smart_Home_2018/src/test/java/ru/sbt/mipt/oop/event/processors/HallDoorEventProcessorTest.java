package ru.sbt.mipt.oop.event.processors;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.event.utilities.SensorEventType;
import ru.sbt.mipt.oop.home.component.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;
import java.io.IOException;

import static org.junit.Assert.*;

public class HallDoorEventProcessorTest extends EventProcessorTest {
    HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor();
    public SmartHome lightsOn;

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        String path = "src/test/resources/smart-home-test-lights-on.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        this.lightsOn = smartHomeLoader.loadSmartHome();
    }

    @Test
    public void processPassiveEvents() {
        for (SensorEvent event : passiveSensorEvents) {
            hallDoorEventProcessor.processEvent(smartHome, event);
        }
        assertEquals(smartHome, initialSmartHome);
    }

    @Test
    public void shuttingAllLights() {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        hallDoorEventProcessor.processEvent(lightsOn, sensorEvent);
        assertEquals(lightsOn, initialSmartHome);
    }
}