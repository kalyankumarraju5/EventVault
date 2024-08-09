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

import com.ems.project.entity.Event;
import com.ems.project.service.EventService;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.fetchAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);
    }
    

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable("id") Long id, @RequestBody Event event) {
        return eventService.updateEventById(id, event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
        return eventService.deleteEventById(id);
    }
}
