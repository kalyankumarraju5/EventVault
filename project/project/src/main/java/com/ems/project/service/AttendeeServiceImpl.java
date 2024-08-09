package com.ems.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.project.entity.Attendee;
import com.ems.project.repository.AttendeeRepository;

@Service
public class AttendeeServiceImpl implements AttendeeService {
	@Autowired
	private AttendeeRepository attendeeRepository;

	@Override
	public Attendee saveAttendee(Attendee attendee) {
		return attendeeRepository.save(attendee);
	}

	@Override
	public List<Attendee> fetchAllAttendees() {
		List<Attendee> allAttendees = attendeeRepository.findAll();
		return allAttendees;
	}

	@Override
	public Attendee getAttendeeById(Long id) {
		Optional<Attendee> attendee = attendeeRepository.findById(id);
		return attendee.orElse(null);
	}

	@Override
	public Attendee updateAttendeeById(Long id, Attendee attendee) {
	    Optional<Attendee> attendeeData = attendeeRepository.findById(id);
	    if (attendeeData.isPresent()) {
	        Attendee existingAttendee = attendeeData.get();

	        // Update fields
	        existingAttendee.setName(attendee.getName());
	        existingAttendee.setEmail(attendee.getEmail());
	        
	        // Optionally update additional fields like status, if applicable
	        // if (attendee.getStatus() != null) {
	        //     existingAttendee.setStatus(attendee.getStatus());
	        // }

	        return attendeeRepository.save(existingAttendee); // Save and return the updated attendee
	    }
	    return null; // Return null if no attendee found with the provided ID
	}


	@Override
	public String deleteAttendeeId(Long id) {
		if (attendeeRepository.findById(id).isPresent()) {
			attendeeRepository.deleteById(id);
			return "Attendee deleted successfully";
		}
		return "No such ticket in the database";
	}

	@Override
	public Attendee save(Attendee attendee) {
		// TODO Auto-generated method stub
		return null;
	}
}
