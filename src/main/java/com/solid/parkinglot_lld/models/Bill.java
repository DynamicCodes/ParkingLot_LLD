package com.solid.parkinglot_lld.models;

import java.util.Date;
import java.util.List;

@lombok.Getter
@lombok.Setter
public class Bill extends BaseModel{
    private Date exitTime;
    private int totalAmount;
    private Ticket ticket;
    private Gate exitGate;

    private List<Payment> payments;

    public Bill(int id, Date exitTime, int totalAmount, Ticket ticket, Gate exitGate) {

        super(id);
        this.exitTime = exitTime;
        this.totalAmount = totalAmount;
        this.ticket = ticket;
        this.exitGate = exitGate;
    }
}
