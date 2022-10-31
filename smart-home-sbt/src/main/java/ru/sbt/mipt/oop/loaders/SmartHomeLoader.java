package ru.sbt.mipt.oop.loaders;

import ru.sbt.mipt.oop.home.component.SmartHome;

import java.io.IOException;

public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;
}
