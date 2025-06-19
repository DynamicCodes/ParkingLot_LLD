package com.solid.parkinglot_lld.repositories;

import com.solid.parkinglot_lld.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    Map<Integer, ParkingLot> parkingLots;
    private static int counter;

    public ParkingLotRepository() {
        this.parkingLots = new TreeMap<>();
        counter = 1;
    }

    public Optional<ParkingLot> getParkingLotById(int id) {
        return Optional.ofNullable(parkingLots.get(id));
    }
    public ParkingLot save(ParkingLot parkingLot) {
        parkingLot.setId(counter);
        parkingLots.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
