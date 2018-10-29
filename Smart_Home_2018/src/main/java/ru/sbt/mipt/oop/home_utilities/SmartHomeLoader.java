package ru.sbt.mipt.oop.home_utilities;

import ru.sbt.mipt.oop.home_components.SmartHome;

import java.io.IOException;

public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;
}
