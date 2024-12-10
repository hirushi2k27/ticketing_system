package com.ticketing.Controller;

import com.ticketing.Model.Ticket;
import com.ticketing.Service.TicketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketPoolService ticketPoolService;

    @PostMapping("/add")
    public String addTicket(@RequestBody Ticket ticket) {
        boolean success = ticketPoolService.addTicketToPool(ticket);
        return success ? "Ticket added successfully." : "Ticket pool is full.";
    }

    @PostMapping("/purchase")
    public Ticket purchaseTicket() {
        return ticketPoolService.purchaseTicketFromPool();
    }

    @GetMapping("/remaining")
    public int getRemainingTickets() {
        return ticketPoolService.getRemainingTickets();
    }
}
