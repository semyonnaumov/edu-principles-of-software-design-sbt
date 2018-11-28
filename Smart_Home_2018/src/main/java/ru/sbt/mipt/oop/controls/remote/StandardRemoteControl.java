package ru.sbt.mipt.oop.controls.remote;

import ru.sbt.mipt.oop.command.Command;
import java.util.HashMap;
import java.util.Map;

public class StandardRemoteControl implements RemoteControl {
    private final String[] buttonIDs = {"A", "B", "C", "D", "1", "2", "3", "4"};
    private Integer iD;
    private Map<String, Button> buttons = new HashMap<>();

    public StandardRemoteControl(Integer iD) {
        initButtons();
        this.iD = iD;
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        Button button = buttons.get(buttonCode);
        button.onPressed();
    }

    public void bindCommandToButton(Command command, Button button) {
        button.setCommand(command);
    }

    private void initButtons() {
        for (String buttonID : buttonIDs) {
            buttons.put(buttonID, new Button(buttonID));
        }
    }
}
