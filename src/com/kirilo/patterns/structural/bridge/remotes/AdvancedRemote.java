package com.kirilo.patterns.structural.bridge.remotes;

import com.kirilo.patterns.structural.bridge.devices.Device;

public class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
