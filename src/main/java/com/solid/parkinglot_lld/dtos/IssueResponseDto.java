package com.solid.parkinglot_lld.dtos;

@lombok.Getter
@lombok.Setter
public class IssueResponseDto {
    private int ticket_id;
    private String parking_slot_number;
    private ResponseStatus response_status;
    private String response_message;
}
