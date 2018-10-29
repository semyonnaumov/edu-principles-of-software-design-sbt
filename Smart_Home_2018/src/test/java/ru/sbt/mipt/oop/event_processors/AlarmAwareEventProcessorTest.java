package ru.sbt.mipt.oop.event_processors;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_utilities.SmartHomeLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class AlarmAwareEventProcessorTest {

    SmartHome smartHome;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-test.js")));
        smartHome = gson.fromJson(json, SmartHome.class);
    }

    @Test
    public void processEvent() {
        assertTrue(true);
    }
}