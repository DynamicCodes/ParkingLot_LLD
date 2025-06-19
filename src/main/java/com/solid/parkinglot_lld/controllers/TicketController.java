package com.solid.parkinglot_lld.controllers;

import com.solid.parkinglot_lld.dtos.IssueRequestDto;
import com.solid.parkinglot_lld.dtos.IssueResponseDto;
import com.solid.parkinglot_lld.dtos.ResponseStatus;
import com.solid.parkinglot_lld.models.Ticket;
import com.solid.parkinglot_lld.services.ITicketService;

public class TicketController {

    private ITicketService ticketService;
    public TicketController(ITicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueResponseDto issueTicket(IssueRequestDto request){

        IssueResponseDto issueResponseDto = new IssueResponseDto();
        try{
            Ticket ticket = ticketService.issueTicket(
                    request.getLicensePlate(),
                    request.getVehicleType(),
                    request.getEntry_gate_id(),
                    request.getOperator_id(),
                    request.getParking_slot_id()
            );
            issueResponseDto.setResponse_status(ResponseStatus.SUCCESS);
            issueResponseDto.setParking_slot_number(ticket.getParkingSlot().getNumber());
        }catch (Exception e){
            issueResponseDto.setResponse_status(ResponseStatus.FAILURE);
            issueResponseDto.setResponse_message(e.getMessage());
        }
        return issueResponseDto;
    }
}
