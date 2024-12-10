package com.ticketing.Service;

import com.ticketing.Model.Configuration;
import com.ticketing.Repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public Configuration getConfiguration() {
        try {
            return configurationRepository.loadConfiguration();
        } catch (Exception e) {
            // Return default configuration if file doesn't exist
            return new Configuration(0, 0, 0, 50);
        }
    }

    public void saveConfiguration(Configuration configuration) {
        configurationRepository.saveConfiguration(configuration);
    }
}