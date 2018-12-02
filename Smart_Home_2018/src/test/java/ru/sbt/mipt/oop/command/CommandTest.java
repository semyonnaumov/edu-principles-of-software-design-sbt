package ru.sbt.mipt.oop.command;

import org.junit.Before;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_components.alarm.Alarm;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import static org.junit.Assert.*;

public class CommandTest {
    protected SmartHome smartHome;
    protected SmartHome initialSmartHome;

    @Before
    public void setUp() throws Exception {
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-test.json");
        smartHome = smartHomeLoader.loadSmartHome();
        initialSmartHome = smartHomeLoader.loadSmartHome();
    }
}