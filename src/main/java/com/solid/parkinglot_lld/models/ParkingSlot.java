package com.solid.parkinglot_lld.models;

@lombok.Getter
@lombok.Setter
public class ParkingSlot extends BaseModel {
    private String number;
    private Status parkingSlotStatus;
    private VehicleType vehicleType;

    public ParkingSlot() {
        super(-1);
    }
}
