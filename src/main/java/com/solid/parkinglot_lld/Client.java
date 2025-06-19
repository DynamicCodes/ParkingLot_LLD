package com.solid.parkinglot_lld;

import com.solid.parkinglot_lld.controllers.TicketController;
import com.solid.parkinglot_lld.dtos.IssueRequestDto;
import com.solid.parkinglot_lld.dtos.IssueResponseDto;
import com.solid.parkinglot_lld.dtos.ResponseStatus;
import com.solid.parkinglot_lld.models.VehicleType;
import com.solid.parkinglot_lld.repositories.GateRepository;
import com.solid.parkinglot_lld.repositories.ParkingLotRepository;
import com.solid.parkinglot_lld.repositories.TicketRepository;
import com.solid.parkinglot_lld.repositories.VehicleRepository;
import com.solid.parkinglot_lld.services.ITicketService;
import com.solid.parkinglot_lld.services.InitializationService;
import com.solid.parkinglot_lld.services.TicketService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitializationService initializationService = new InitializationService(parkingLotRepository);
        initializationService.initializeParkingLot();

        ITicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository
        );
        // Here you can create a controller and use the ticketService to issue tickets
        TicketController ticketController = new TicketController(ticketService);
        IssueRequestDto issueRequestDto = new IssueRequestDto();
        issueRequestDto.setEntry_gate_id(1);
        issueRequestDto.setLicensePlate("ABC123");
        issueRequestDto.setOperator_id(1);
        issueRequestDto.setParking_slot_id(1);
        issueRequestDto.setVehicleType(VehicleType.ELECTRIC_VEHICLE);

        // Issue a ticket
        IssueResponseDto issueResponseDto = ticketController.issueTicket(issueRequestDto);
        if(issueResponseDto.getResponse_status().equals(ResponseStatus.FAILURE)) {
            System.out.println("Failed to issue Ticket");
            System.out.println(issueResponseDto.getResponse_message());
        }else{
            System.out.println("Ticket issued successfully");
            System.out.println("Ticket ID: " + issueResponseDto.getTicket_id());
            System.out.println("Parking Slot Number: " + issueResponseDto.getParking_slot_number());
        }
    }
}
