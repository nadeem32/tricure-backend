package com.tricure.backend.controller;

import com.tricure.backend.entity.CompanySettings;
import com.tricure.backend.repository.CompanySettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "*")
public class CompanySettingsController {

    @Autowired
    private CompanySettingsRepository repository;

    @GetMapping
    public CompanySettings getSettings() {
        return repository.findById(1L).orElseGet(() -> {
            CompanySettings defaultSettings = new CompanySettings();
            defaultSettings.setId(1L);
            defaultSettings.setMissionStatement("Innovating healthcare for a better tomorrow.");
            defaultSettings.setHistory("Founded in 2024, Tricure Innovations has been at the forefront of medical technology.");
            defaultSettings.setEmail("info@tricureinnovations.com");
            defaultSettings.setPhone("+1 (555) 123-4567");
            defaultSettings.setAddress("123 Innovation Dr, Tech City, TC 90210");
            return repository.save(defaultSettings);
        });
    }

    @PutMapping
    public CompanySettings updateSettings(@RequestBody CompanySettings settings) {
        settings.setId(1L); // Ensure singleton
        return repository.save(settings);
    }
}
