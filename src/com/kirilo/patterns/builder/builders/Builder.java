package com.kirilo.patterns.builder.builders;

import com.kirilo.patterns.builder.components.*;

public interface Builder {
    void setType(Type type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGpsNavigator(GPSNavigator gpsNavigator);
}
