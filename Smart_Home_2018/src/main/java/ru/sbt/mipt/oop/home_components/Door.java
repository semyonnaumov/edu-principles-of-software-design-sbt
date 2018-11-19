package ru.sbt.mipt.oop.home_components;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.ActionExecutor;

public class Door implements ActionExecutor {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
