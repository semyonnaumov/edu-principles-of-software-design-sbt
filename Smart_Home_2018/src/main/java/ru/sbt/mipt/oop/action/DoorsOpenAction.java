package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.home_components.Door;

public class DoorsOpenAction implements Action {
    @Override
    public void execute(Object object) {
        if (object instanceof Door) {
            Door door = (Door) object;
            door.setOpen(true);
        }
    }
}
