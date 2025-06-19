package com.solid.parkinglot_lld.strategies;

import com.solid.parkinglot_lld.models.ParkingLot;
import com.solid.parkinglot_lld.models.ParkingSlot;
import com.solid.parkinglot_lld.models.VehicleType;

public interface SlotAllocationTypeStrategy {
    ParkingSlot allocateSlot(VehicleType vehicleType, ParkingLot parkingLot);
}
