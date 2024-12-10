package com.ticketing.Controller;

import com.ticketing.Model.Configuration;
import com.ticketing.Model.ConfigurationDTO;
import com.ticketing.Service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
@CrossOrigin(origins = "*")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping
    public ResponseEntity<Configuration> getConfiguration() {
        try {
            Configuration config = configurationService.getConfiguration();
            return ResponseEntity.ok(config);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> saveConfiguration(@RequestBody ConfigurationDTO configDTO) {
        try {
            Configuration config = new Configuration(
                    configDTO.getTotalTickets(),
                    configDTO.getTicketReleaseRate(),
                    configDTO.getCustomerRetrievalRate(),
                    configDTO.getMaxTicketCapacity()
            );
            configurationService.saveConfiguration(config);
            return ResponseEntity.ok("Configuration saved successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error saving configuration: " + e.getMessage());
        }
    }
}