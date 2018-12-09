package ru.sbt.mipt.oop.controls.remote;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.home.component.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.command.CommandType.*;

public class StandardRemoteControlTest {
    private SmartHome smartHome;
    private SmartHome initialSmartHome;
    private SmartHome lightsOnSmartHome;
    private RemoteControl remoteControl1;
    private RemoteControl remoteControl2;

    @Before
    public void setUp() throws Exception {
        String path1 = "src/test/resources/smart-home-test.json";
        String path2 = "src/test/resources/smart-home-test-lights-on.json";

        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path1);
        SmartHomeLoader lightsOnSmartHomeLoader = new FileSmartHomeLoader(path2);
        smartHome = smartHomeLoader.loadSmartHome();
        initialSmartHome = smartHomeLoader.loadSmartHome();
        lightsOnSmartHome = lightsOnSmartHomeLoader.loadSmartHome();
        remoteControl1 = new StandardRemoteControl("0");
        remoteControl2 = new StandardRemoteControl("1");
    }

    @Test
    public void bindToSmartHome() {
        remoteControl1.bindToSmartHome(smartHome);
        assertTrue(remoteControl1.getCommands().containsKey(EMPTY));
        assertTrue(remoteControl1.getCommands().containsKey(ACTIVATE_ALARM));
        assertTrue(remoteControl1.getCommands().containsKey(CLOSE_HALL_DOOR));
        assertTrue(remoteControl1.getCommands().containsKey(HALL_LIGHTS_ON));
        assertTrue(remoteControl1.getCommands().containsKey(HOME_LIGHTS_ON));
        assertTrue(remoteControl1.getCommands().containsKey(HOME_LIGHTS_OFF));
        assertTrue(remoteControl1.getCommands().containsKey(INVOKE_ALERT_ALARM));
    }

    @Test
    public void onButtonPressed() {
        remoteControl1.bindToSmartHome(smartHome);
        remoteControl1.onButtonPressed("1");
        remoteControl1.onButtonPressed("2");
        remoteControl1.onButtonPressed("3");
        remoteControl1.onButtonPressed("4");
        remoteControl1.onButtonPressed("A");
        remoteControl1.onButtonPressed("B");
        remoteControl1.onButtonPressed("C");
        remoteControl1.onButtonPressed("D");

        assertTrue(smartHome.equals(initialSmartHome));

        remoteControl1.bindCommandToButton(HOME_LIGHTS_ON,"1");
        remoteControl1.onButtonPressed("1");
        assertFalse(smartHome.equals(initialSmartHome));
        assertTrue(smartHome.equals(lightsOnSmartHome));
    }

    @Test
    public void bindCommandToButton() {
        remoteControl1.bindToSmartHome(smartHome);
        assertTrue(remoteControl1.getButtons().get("1").getCommand().getType() == EMPTY);
        remoteControl1.bindCommandToButton(ACTIVATE_ALARM, "1");
        assertTrue(remoteControl1.getButtons().get("1").getCommand().getType() == ACTIVATE_ALARM);
    }
}