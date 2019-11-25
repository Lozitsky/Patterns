package com.kirilo.patterns.structural.bridge.devices;

public class Tv implements Device {
    private boolean on;
    private int volume = 10;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent > 100) {
            volume = 100;
        } else volume = Math.max(percent, 0);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Tv{" +
                "on=" + on +
                ", volume=" + volume + "%" +
                ", channel=" + channel +
                '}';
    }
}
