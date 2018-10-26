package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;

public class LightsEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (isLightEvent(event)) {
            smartHome.executeAction(object -> {
                if (object instanceof Light) {
                    Light light = (Light) object;
                    if (event.getObjectId().equals(light.getId())){
                        if (event.getType() == LIGHT_ON) {
                            light.setOn(true);
                        }
                        if (event.getType() == LIGHT_OFF) {
                            light.setOn(false);
                        }
                    }
                }
            });
        }
    }

    private boolean isLightEvent(SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            return true;
        } else {
            return false;
        }
    }
}
