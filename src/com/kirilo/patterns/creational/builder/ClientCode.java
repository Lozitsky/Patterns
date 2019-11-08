package com.kirilo.patterns.creational.builder;

import com.kirilo.patterns.creational.builder.builders.CarBuilder;
import com.kirilo.patterns.creational.builder.builders.CarManualBuilder;
import com.kirilo.patterns.creational.builder.director.Director;
import com.kirilo.patterns.creational.builder.objects.Car;
import com.kirilo.patterns.creational.builder.objects.Manual;

public class ClientCode {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);

        Car result = carBuilder.getResult();
        System.out.println("Car built:\n" + result.getType());

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructSportsCar(carManualBuilder);
        Manual manual = carManualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + manual.print());
    }
}
