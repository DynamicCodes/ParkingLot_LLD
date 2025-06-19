package com.solid.parkinglot_lld.repositories;

import com.solid.parkinglot_lld.models.Ticket;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    Map<Integer, Ticket> tickets;
    private static int counter;

    public TicketRepository() {
        tickets = new TreeMap<>();
        counter = 1;
    }
    public Ticket save(Ticket ticket) {
        ticket.setId(counter++);
        ticket.setEntryTime(Calendar.getInstance().getTime());
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }
}
