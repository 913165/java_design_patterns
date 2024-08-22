package org.designpattern.creational.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {
    @Test
    void testGetCar() {
        Vehicle car = VehicleFactory.getVehicle("CAR");
        assertNotNull(car);
        assertTrue(car instanceof Car);
        car.drive();
    }

    @Test
    void testGetBike() {
        Vehicle bike = VehicleFactory.getVehicle("BIKE");
        assertNotNull(bike);
        assertTrue(bike instanceof Bike);
        bike.drive();
    }

    @Test
    void testGetTruck() {
        Vehicle truck = VehicleFactory.getVehicle("TRUCK");
        assertNotNull(truck);
        assertTrue(truck instanceof Truck);
        truck.drive();
    }

    @Test
    void testGetUnknownVehicle() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            VehicleFactory.getVehicle("bicycle");  // This should throw an exception
        });
        assertEquals("Unknown vehicle type: bicycle", exception.getMessage());
    }

    @Test
    void testGetNullVehicle() {
        Vehicle vehicle = VehicleFactory.getVehicle(null);
        assertNull(vehicle);

        
    }

}