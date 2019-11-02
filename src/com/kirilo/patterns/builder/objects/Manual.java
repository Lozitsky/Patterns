package com.kirilo.patterns.builder.objects;

import com.kirilo.patterns.builder.components.*;

public class Manual {
    private final Type type;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;

    public Manual(Type type, int seats, Engine engine, Transmission transmission, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        StringBuilder info = new StringBuilder()
                .append("Type of car: ").append(type).append("\n")
                .append("Count of seats: ").append(seats).append("\n")
                .append("Engine: volume - ").append(engine.getVolume())
                .append("; mileage - ").append(engine.getMileage()).append("\n")
                .append("Transmission: ").append(transmission).append("\n");
        if (this.tripComputer != null) {
            info.append(new StringBuilder().append("Trip Computer: Functional").append("\n").toString());
        } else {
            info.append("Trip Computer: N/A").append("\n");
        }
        if (this.gpsNavigator != null) {
            info.append("GPS Navigator: Functional").append("\n");
        } else {
            info.append("GPS Navigator: N/A").append("\n");
        }
        return info.toString();
    }
}
