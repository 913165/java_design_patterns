package org.designpattern.creational.factory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("CAR");
        car.drive();

        Vehicle bike = VehicleFactory.getVehicle("BIKE");
        bike.drive();

        Vehicle truck = VehicleFactory.getVehicle("TRUCK");
        truck.drive();
    }
}
