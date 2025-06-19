package com.solid.parkinglot_lld.strategies;

import com.solid.parkinglot_lld.models.*;

public class NearestSlotAllocation implements SlotAllocationTypeStrategy{
    @Override
    public ParkingSlot allocateSlot(VehicleType vehicleType, ParkingLot parkingLot) {
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            for(ParkingSlot slot : floor.getParkingSlots()){
                if(slot.getVehicleType().equals(vehicleType) &&
                slot.getParkingSlotStatus().equals(Status.AVAILABLE)){
                    slot.setParkingSlotStatus(Status.FULL);
                    return slot;
                }
            }

        }
        return null;
    }
}
