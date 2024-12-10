package com.ticketing.Service;

import com.ticketing.Model.Vendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {

    private final List<Vendor> vendors = new ArrayList<>();

    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public Vendor getVendorById(int vendorId) {
        return vendors.stream()
                .filter(v -> v.getVendorId() == vendorId)
                .findFirst()
                .orElse(null);
    }
}

