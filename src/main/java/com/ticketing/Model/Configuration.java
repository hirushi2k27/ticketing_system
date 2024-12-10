package com.ticketing.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets=totalTickets;
        this.ticketReleaseRate=ticketReleaseRate;
        this.customerRetrievalRate=customerRetrievalRate;
        this.maxTicketCapacity=maxTicketCapacity;
    }
}

