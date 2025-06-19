package com.solid.parkinglot_lld.models;

import java.util.Date;

@lombok.Getter
@lombok.Setter
public class Ticket extends BaseModel{

    private Date entryTime;
    private Vehicle vehicle;
    private Gate entryGate;
    private ParkingSlot parkingSlot;

    public Ticket() {
        super(-1);
    }
}
