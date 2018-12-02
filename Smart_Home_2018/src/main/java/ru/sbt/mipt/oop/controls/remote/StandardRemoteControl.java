package ru.sbt.mipt.oop.controls.remote;

import ru.sbt.mipt.oop.command.*;
import ru.sbt.mipt.oop.home_components.SmartHome;
import java.util.HashMap;
import java.util.Map;

import static ru.sbt.mipt.oop.command.CommandType.*;

public class StandardRemoteControl implements RemoteControl {
    private final String[] buttonIDs = {"A", "B", "C", "D", "1", "2", "3", "4"};
    private Integer ID;
    private SmartHome smartHome = null;
    private Map<CommandType, Command> commands = null;
    private Map<String, Button> buttons = null;

    public StandardRemoteControl(Integer ID) {
        this.ID = ID;
    }
    @Override
    public SmartHome getSmartHome() {
        return smartHome;
    }
    @Override
    public Map<CommandType, Command> getCommands() {
        return commands;
    }

    @Override
    public Map<String, Button> getButtons() {
        return buttons;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void bindToSmartHome(SmartHome smartHome) {
        this.setSmartHome(smartHome);
        commands = new HashMap<>();
        commands.put(EMPTY, new EmptyCommand());
        commands.put(ACTIVATE_ALARM, new ActivateAlarmCommand(smartHome, 12345));
        commands.put(CLOSE_HALL_DOOR, new CloseHallDoorCommand(smartHome));
        commands.put(HALL_LIGHTS_ON, new HallLightsOnCommand(smartHome));
        commands.put(HOME_LIGHTS_OFF, new HomeLightsOffCommand(smartHome));
        commands.put(HOME_LIGHTS_ON, new HomeLightsOnCommand(smartHome));
        commands.put(INVOKE_ALERT_ALARM, new InvokeAlertAlarmCommand(smartHome));

        buttons = new HashMap<>();
        for (String buttonID : buttonIDs) {
            buttons.put(buttonID, new Button(buttonID));
        }
        smartHome.addRemoteControl(this);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        if (!readyToWork()) {
            return;
        }
        Button button = buttons.get(buttonCode);
        button.onPressed();
    }

    @Override
    public void bindCommandToButton(CommandType commandType, String buttonID) {
        if (!readyToWork()) {
            return;
        }
        Command command = commands.get(commandType);
        Button button = buttons.get(buttonID);
        button.setCommand(command);
    }

    private boolean readyToWork() {
        if (buttons != null && smartHome != null && commands != null) {
            return true;
        }
        return false;
    }

    private void setSmartHome(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
}
