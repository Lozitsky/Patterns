package com.kirilo.patterns.creational.builder.car_builder;

import com.kirilo.patterns.creational.builder.car_builder.builders.CarBuilder;
import com.kirilo.patterns.creational.builder.car_builder.builders.CarManualBuilder;
import com.kirilo.patterns.creational.builder.car_builder.director.Director;
import com.kirilo.patterns.creational.builder.car_builder.objects.Car;
import com.kirilo.patterns.creational.builder.car_builder.objects.Manual;

public class Demo {
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
