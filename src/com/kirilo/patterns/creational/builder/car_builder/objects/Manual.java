package com.kirilo.patterns.creational.builder.car_builder.objects;

import com.kirilo.patterns.creational.builder.car_builder.components.*;

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
                .append(String.format("Type of car: %s\n", type))
                .append(String.format("Count of seats: %d\n", seats))
                .append(String.format("Engine: volume - %1$.2f; mileage - %2$.2f\n", engine.getVolume(), engine.getMileage()))
                .append(String.format("Transmission: %s\n", transmission))
                .append(String.format("Trip Computer: %s\n", getInfo(this.tripComputer != null)))
                .append(String.format("GPS Navigator: %s\n", getInfo(this.gpsNavigator != null)));
        return info.toString();
    }

    private String getInfo(boolean predicate) {
        return predicate ? "Functional" : "N/A";
    }
}
