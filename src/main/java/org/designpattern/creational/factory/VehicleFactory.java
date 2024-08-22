package org.designpattern.creational.factory;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike");
    }
}

class Truck implements  Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck");
    }
}

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("BIKE")) {
            return new Bike();
        } else if (vehicleType.equalsIgnoreCase("TRUCK")) {
            return new Truck();
        }
        throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
    }
}
