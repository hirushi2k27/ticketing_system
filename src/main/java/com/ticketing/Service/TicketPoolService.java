package com.ticketing.Service;

import com.ticketing.Model.Ticket;
import com.ticketing.Model.TicketPool;
import org.springframework.stereotype.Service;

@Service
public class TicketPoolService {

    private final TicketPool ticketPool = new TicketPool(50); // Example max capacity

    public boolean addTicketToPool(Ticket ticket) {
        return ticketPool.addTicket(ticket);
    }

    public Ticket purchaseTicketFromPool() {
        return ticketPool.removeTicket();
    }

    public int getRemainingTickets() {
        return ticketPool.getRemainingCapacity();
    }
}

