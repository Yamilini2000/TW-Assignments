package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exceptions.AlreadyParkedException;
import com.thoughtworks.parkinglot.exceptions.ParkingLotFullException;
import com.thoughtworks.parkinglot.exceptions.VehicleNotParkedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void shouldParkACarWhenSpaceIsAvailable() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(10);
        Parkable car = new Car();

        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }

    @Test
    void shouldNotParkACarWhenSpaceIsNotAvailable() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);
        Parkable car = new Car();
        Parkable anotherCar = new Car();
        parkingLot.park(car);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(anotherCar));
    }

    @Test
    void shouldNotParkTheCarWhenTheCarIsAlreadyParked() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2);
        Parkable car = new Parkable() {
        };
        parkingLot.park(car);

        assertThrows(AlreadyParkedException.class, () -> parkingLot.park(car));
    }

    @Test
    void shouldUnparkTheCarWhenCarIsParked() throws ParkingLotFullException, AlreadyParkedException, VehicleNotParkedException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        parkingLot.unpark(car);

        assertFalse(parkingLot.isParked(car));
    }

    @Test
    void shouldNotUnparkTheCarWhenTheCarIsNotParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        assertThrows(VehicleNotParkedException.class, () -> parkingLot.unpark(car));
    }

    @Test
    void shouldNotifyTheOwnerWhenParkingLotIsFull() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        parkingLot.sendNotification();

        assertTrue(parkingLot.isNotified());
    }
}
