package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.home.component.Light;

public class LightsOnAction implements Action {
    @Override
    public void execute(Object object) {
        if (object instanceof Light) {
            Light light = (Light) object;
            light.setOn(true);
        }
    }
}
