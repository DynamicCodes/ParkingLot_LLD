package com.solid.parkinglot_lld.models;

import com.solid.parkinglot_lld.strategies.SlotAllocationTypeStrategy;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private Status parkingLotStatus;
    private int capacity;
    private List<VehicleType> VehicleTypes;
    private SlotAllocationTypeStrategy slotAllocationTypeStrategy;

    public ParkingLot() {
        super(-1);
    }

}
