package com.ticketing.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketing.Model.Configuration;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class ConfigurationRepository {
    private final String CONFIG_FILE = "config.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Configuration loadConfiguration() {
        File file = Paths.get(CONFIG_FILE).toFile();
        if (!file.exists()) {
            return new Configuration(0, 0, 0, 50);
        }
        try {
            return objectMapper.readValue(file, Configuration.class);
        } catch (IOException e) {
            throw new RuntimeException("Error reading configuration: " + e.getMessage());
        }
    }

    public void saveConfiguration(Configuration configuration) {
        try {
            objectMapper.writeValue(Paths.get(CONFIG_FILE).toFile(), configuration);
        } catch (IOException e) {
            throw new RuntimeException("Error saving configuration: " + e.getMessage());
        }
    }
}