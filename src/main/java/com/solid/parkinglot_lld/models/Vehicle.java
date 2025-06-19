package com.solid.parkinglot_lld.models;

@lombok.Getter
@lombok.Setter
public class Vehicle extends BaseModel {
    private VehicleType vehicleType;
    private String licensePlate;

    public Vehicle(VehicleType vehicleType, String licensePlate) {
        super(-1);
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }
}
