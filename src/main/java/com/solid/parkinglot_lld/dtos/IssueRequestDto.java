package com.solid.parkinglot_lld.dtos;

import com.solid.parkinglot_lld.models.VehicleType;

@lombok.Getter
@lombok.Setter
public class IssueRequestDto {
    private String licensePlate;
    private VehicleType vehicleType;
    private int operator_id;
    private int entry_gate_id;
    private int parking_slot_id;
}
