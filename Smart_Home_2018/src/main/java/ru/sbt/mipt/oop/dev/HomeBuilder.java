package ru.sbt.mipt.oop.dev;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sbt.mipt.oop.home.component.Door;
import ru.sbt.mipt.oop.home.component.Light;
import ru.sbt.mipt.oop.home.component.Room;
import ru.sbt.mipt.oop.home.component.SmartHome;
import ru.sbt.mipt.oop.home.component.alarm.Alarm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");
        Room bathroom = new Room(Arrays.asList(new Light("3", true)),
                Arrays.asList(new Door(false, "2")),
                "bathroom");
        Room bedroom = new Room(Arrays.asList(new Light("4", false), new Light("5", false), new Light("6", false)),
                Arrays.asList(new Door(true, "3")),
                "bedroom");
        Room hall = new Room(Arrays.asList(new Light("7", false), new Light("8", false), new Light("9", false)),
                Arrays.asList(new Door(false, "4")),
                "hall");

        List<Room> rooms = Arrays.asList(kitchen, bathroom, bedroom, hall);
        Alarm alarm = new Alarm(12345);
        SmartHome smartHome = new SmartHome(rooms);

        //smartHome.setAlarm(alarm);
        //RemoteControl rc1 = new StandardRemoteControl(1000);
        //rc1.bindToSmartHome(smartHome);
        //RemoteControl rc2 = new StandardRemoteControl(2000);
        //rc2.bindToSmartHome(smartHome);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path path = Paths.get("output.json");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }

}
