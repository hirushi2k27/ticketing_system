package com.ticketing.Model;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class TicketPool {
    private final Queue<Ticket> ticketQueue = new LinkedList<>();
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized boolean addTicket(Ticket ticket) {
        if (ticketQueue.size() >= maxCapacity) {
            return false; // Pool is full
        }
        ticketQueue.add(ticket);
        return true;
    }

    public synchronized Ticket removeTicket() {
        return ticketQueue.poll(); // Return null if empty
    }

    public synchronized int getRemainingCapacity() {
        return maxCapacity - ticketQueue.size();
    }
}

