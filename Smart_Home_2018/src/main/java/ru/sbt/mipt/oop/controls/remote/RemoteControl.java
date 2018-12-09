package ru.sbt.mipt.oop.controls.remote;

import ru.sbt.mipt.oop.command.Command;
import ru.sbt.mipt.oop.command.CommandType;
import ru.sbt.mipt.oop.home.component.SmartHome;

import java.util.Map;

public interface RemoteControl {
    void onButtonPressed(String buttonCode);
    void bindToSmartHome(SmartHome smartHome);
    void bindCommandToButton(CommandType commandType, String buttonID);

    //SmartHome getSmartHome();
    Map<CommandType, Command> getCommands();
    Map<String, Button> getButtons();
    String getID();
}
