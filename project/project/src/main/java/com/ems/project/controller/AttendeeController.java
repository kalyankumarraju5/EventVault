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

import com.ems.project.entity.Attendee;
import com.ems.project.service.AttendeeService;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/attendee")
public class AttendeeController {
	
    @Autowired
    private AttendeeService attendeeService;

    @PostMapping
    public Attendee createAttendee(@RequestBody Attendee attendee) {
        return attendeeService.saveAttendee(attendee);
    }
    @GetMapping
    public List<Attendee> getAllAttendees() {
        return attendeeService.fetchAllAttendees();
    }

    @GetMapping("/{id}")
    public Attendee getAttendeeById(@PathVariable("id") Long id) {
        return attendeeService.getAttendeeById(id);
    }

    @PutMapping("/{id}")
    public Attendee updateAttendee(@PathVariable("id") Long id, @RequestBody Attendee attendee) {
        return attendeeService.updateAttendeeById(id, attendee);
    }

    @DeleteMapping("/{id}")
    public String deleteAttendee(@PathVariable("id") Long id) {
        return attendeeService.deleteAttendeeId(id);
    }
}
