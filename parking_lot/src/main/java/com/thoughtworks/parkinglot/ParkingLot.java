package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exceptions.AlreadyParkedException;
import com.thoughtworks.parkinglot.exceptions.ParkingLotFullException;
import com.thoughtworks.parkinglot.exceptions.VehicleNotParkedException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private final List<Parkable> vehicles;
    private boolean parkingLotFull = false;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
    }

    public void park(Parkable vehicle) throws ParkingLotFullException, AlreadyParkedException {
        if (!isSpaceAvailable())
            throw new ParkingLotFullException();
        if (isParked(vehicle))
            throw new AlreadyParkedException();
        vehicles.add(vehicle);
    }

    public void unpark(Parkable vehicle) throws VehicleNotParkedException {
        if (!isParked(vehicle))
            throw new VehicleNotParkedException();
        vehicles.remove(vehicle);
    }

    public boolean isParked(Parkable vehicle) {
        return vehicles.contains(vehicle);
    }

    private boolean isSpaceAvailable() {
        return vehicles.size() < capacity;
    }

    public void sendNotification() {
        parkingLotFull = true;
    }

    public boolean isNotified() {
        return parkingLotFull;
    }
}
