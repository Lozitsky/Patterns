package com.kirilo.patterns.creational.builder.car_builder.builders;

import com.kirilo.patterns.creational.builder.car_builder.components.*;

public interface Builder {
    void setType(Type type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGpsNavigator(GPSNavigator gpsNavigator);
}
