package com.ticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealTimeEventTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeEventTicketingSystemApplication.class, args);
		System.out.println("Ticketing system Backend is running......");
	}

}
