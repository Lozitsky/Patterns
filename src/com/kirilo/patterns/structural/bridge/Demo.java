package com.kirilo.patterns.structural.bridge;

import com.kirilo.patterns.structural.bridge.devices.Device;
import com.kirilo.patterns.structural.bridge.devices.Radio;
import com.kirilo.patterns.structural.bridge.devices.Tv;
import com.kirilo.patterns.structural.bridge.remotes.AdvancedRemote;
import com.kirilo.patterns.structural.bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Radio());
        testDevice(new Tv());
    }

    private static void testDevice(Device device) {
        System.out.println("\nTest with basic remote");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();
        basicRemote.channelUp();

        System.out.println("\nTest with advanced remote");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
