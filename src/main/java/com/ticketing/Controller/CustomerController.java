package com.ticketing.Controller;

import com.ticketing.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String addCustomer(@RequestParam int customerId) {
        customerService.addCustomer(customerId);
        return "Customer added.";
    }
}

