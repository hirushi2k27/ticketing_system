package com.ticketing.Controller;

import com.ticketing.Model.Vendor;
import com.ticketing.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public String addVendor(@RequestBody Vendor vendor) {
        vendorService.addVendor(vendor);
        return "Vendor added successfully.";
    }

    @GetMapping
    public List<Vendor> getVendors() {
        return vendorService.getVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable int id) {
        return vendorService.getVendorById(id);
    }
}

