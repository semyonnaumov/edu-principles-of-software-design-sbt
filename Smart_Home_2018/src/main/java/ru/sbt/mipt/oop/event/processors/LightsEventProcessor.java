package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.utilities.SensorEvent;
import ru.sbt.mipt.oop.event.utilities.SensorEventType;
import ru.sbt.mipt.oop.home_components.Light;
import ru.sbt.mipt.oop.home_components.SmartHome;

public class LightsEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (isLightEvent(event)) {
            smartHome.executeAction(object -> {
                if (object instanceof Light) {
                    Light light = (Light) object;
                    if (event.getObjectId().equals(light.getId())){
                        if (event.getType() == SensorEventType.LIGHT_ON) {
                            light.setOn(true);
                        }
                        if (event.getType() == SensorEventType.LIGHT_OFF) {
                            light.setOn(false);
                        }
                    }
                }
            });
        }
    }

    private boolean isLightEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.LIGHT_ON || event.getType() == SensorEventType.LIGHT_OFF) {
            return true;
        } else {
            return false;
        }
    }
}
