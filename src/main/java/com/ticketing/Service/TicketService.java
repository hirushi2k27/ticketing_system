package com.ticketing.Service;

import com.ticketing.Model.Ticket;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TicketService {

    private final Queue<Ticket> ticketPool = new ConcurrentLinkedQueue<>();

    public void addTicket(Ticket ticket) {
        ticketPool.add(ticket);
    }

    public boolean purchaseTicket(int customerId) {
        return ticketPool.poll() != null;
    }

    public int getAvailableTickets() {
        return ticketPool.size();
    }
}

