package ru.sbt.mipt.oop.event.processors;

import org.junit.Before;
import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;
import java.io.IOException;
import java.util.ArrayList;
import static ru.sbt.mipt.oop.event.utilities.SensorEventType.*;

public abstract class EventProcessorTest {
    protected SmartHome initialSmartHome;
    protected SmartHome smartHome;
    protected ArrayList<SensorEvent> passiveSensorEvents = new ArrayList<SensorEvent>();
    protected ArrayList<SensorEvent> activeSensorEvents = new ArrayList<SensorEvent>();

    @Before
    public void setUp() throws IOException {
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-test.json");
        this.initialSmartHome = smartHomeLoader.loadSmartHome();
        this.smartHome = smartHomeLoader.loadSmartHome();

        passiveSensorEvents.add(new SensorEvent(DOOR_CLOSED, "1"));
        passiveSensorEvents.add(new SensorEvent(DOOR_CLOSED, "2"));
        passiveSensorEvents.add(new SensorEvent(LIGHT_OFF, "1"));
        passiveSensorEvents.add(new SensorEvent(LIGHT_OFF, "2"));
        passiveSensorEvents.add(new SensorEvent(LIGHT_OFF, "3"));

        activeSensorEvents.add(new SensorEvent(DOOR_OPEN, "1"));
        activeSensorEvents.add(new SensorEvent(DOOR_OPEN, "2"));
        activeSensorEvents.add(new SensorEvent(LIGHT_ON, "1"));
        activeSensorEvents.add(new SensorEvent(LIGHT_ON, "2"));
        activeSensorEvents.add(new SensorEvent(LIGHT_ON, "3"));
    }
}
