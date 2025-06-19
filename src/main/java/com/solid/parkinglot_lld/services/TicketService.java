package com.solid.parkinglot_lld.services;

import com.solid.parkinglot_lld.models.*;
import com.solid.parkinglot_lld.repositories.GateRepository;
import com.solid.parkinglot_lld.repositories.ParkingLotRepository;
import com.solid.parkinglot_lld.repositories.TicketRepository;
import com.solid.parkinglot_lld.repositories.VehicleRepository;

import java.util.Optional;

public class TicketService implements ITicketService {
    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;
    TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket issueTicket(String licenseplate, VehicleType vehicleType, int gateId, int operatorid, int parkingSlotId) {
        // 1. obtain the gate from the gate_id
        Optional<Gate> gateOptional = gateRepository.findById(gateId);

        if(gateOptional.isEmpty()) {
            throw new IllegalArgumentException("Gate not found");
        }

        Gate gate = gateOptional.get();
        gate.getOperator().setId(operatorid);

        // 2. validate and save the vehicle
        Optional<Vehicle> vehicleOptinal = vehicleRepository.findByLicensePlate(licenseplate);
        Vehicle vehicle;
        if(vehicleOptinal.isEmpty()) {
            vehicle = vehicleRepository.save(vehicleType, licenseplate);
        }else{
            vehicle = vehicleOptinal.get();
        }

        // 3. assign the parking slot
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotById(parkingSlotId);
        if(parkingLotOptional.isEmpty()) {
            throw new IllegalArgumentException("Parking slot not found");
        }
        ParkingLot parkingLot = parkingLotOptional.get();
        ParkingSlot parkingSlot = parkingLot
                .getSlotAllocationTypeStrategy()
                .allocateSlot(vehicleType, parkingLot);

        // 4. return ticket
        Ticket ticket = new Ticket();
        ticket.setEntryGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setParkingSlot(parkingSlot);
        return ticketRepository.save(ticket);
    }
}
