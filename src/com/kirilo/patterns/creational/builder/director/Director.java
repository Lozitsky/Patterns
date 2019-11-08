package com.kirilo.patterns.creational.builder.director;

import com.kirilo.patterns.creational.builder.builders.Builder;
import com.kirilo.patterns.creational.builder.components.*;

public class Director {
    public void constructSportsCar(Builder builder) {
        builder.setEngine(new Engine(3.0, 0));
        builder.setGpsNavigator(new GPSNavigator());
        builder.setSeats(2);
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setType(Type.SPORTS_CAR);
    }

    public void constructCityCar(Builder builder) {
        builder.setEngine(new Engine(1.2, 0));
        builder.setGpsNavigator(new GPSNavigator());
        builder.setSeats(2);
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setType(Type.CITY_CAR);
    }

    public void constructSUV(Builder builder) {
        builder.setType(Type.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGpsNavigator(new GPSNavigator());
    }
}
