package com.solid.parkinglot_lld.models;

@lombok.Getter
@lombok.Setter
public class ParkingFloor extends BaseModel{
    private String number;
    private List<ParkingSlot> parkingSlots;
    private Status parkingFloorStatus;
    private List<VehicleType> vehicleTypes;

    public ParkingFloor() {
        super  (-1);
    }

}
