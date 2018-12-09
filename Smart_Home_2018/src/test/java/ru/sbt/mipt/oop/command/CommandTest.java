package ru.sbt.mipt.oop.command;

import org.junit.Before;
import ru.sbt.mipt.oop.home.component.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

public class CommandTest {
    protected SmartHome smartHome;

    @Before
    public void setUp() throws Exception {
        String path = "src/test/resources/smart-home-test.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        smartHome = smartHomeLoader.loadSmartHome();
    }
}