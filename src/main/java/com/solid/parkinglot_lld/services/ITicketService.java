package com.solid.parkinglot_lld.services;

import com.solid.parkinglot_lld.models.Ticket;
import com.solid.parkinglot_lld.models.VehicleType;

public interface ITicketService {
    Ticket issueTicket(String licenseplate, VehicleType vehicleType,
                       int gateId, int operatorid, int parkingSlotId);
}
