package com.ticketing.Service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerService {

    private final Set<Integer> customers = new HashSet<>();

    public void addCustomer(int customerId) {
        customers.add(customerId);
    }
}

