package com.ems.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.project.entity.Organizer;
import com.ems.project.service.OrganizerService;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/organizer")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.saveOrganizer(organizer);
    }
    @GetMapping
    public List<Organizer> getAllOrganizers() {
        return organizerService.fetchAllOrganizers();
    }

    @GetMapping("/{id}")
    public Organizer getOrganizerById(@PathVariable("id") Long id) {
        return organizerService.getOrganizerById(id);
    }

    @PutMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable("id") Long id, @RequestBody Organizer organizer) {
        return organizerService.updateOrganizerById(id, organizer);
    }

    @DeleteMapping("/{id}")
    public String deleteOrganizer(@PathVariable("id") Long id) {
        return organizerService.deleteOrganizerById(id);
    }
}

