package com.ems.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.project.entity.Event;
import com.ems.project.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> fetchAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Event getEventById(Long id) {
		try {
	        Optional<Event> event = eventRepository.findById(id);
	        return event.orElse(null); // Returns the event if present or null if not found
	    } catch (Exception e) {
	        // Log the exception for debugging
	        System.out.println("Error fetching event with ID " + id + ": " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public String deleteEventById(Long id) {
		if (eventRepository.existsById(id)) {
			eventRepository.deleteById(id);
			return "Event deleted successfully.";
		}
		return "No such event found.";
	}

	@Override
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event updateEventById(Long id, Event event) {
		Optional<Event> event1 = eventRepository.findById(id);
		if (event1.isPresent()) {

			Event existingEvent = event1.get();
			// Assuming Event has methods setTitle, setDescription, etc.
			existingEvent.setTitle(event.getTitle());
			existingEvent.setDescription(event.getDescription());
			//existingEvent.setDate(event.get); // Assuming there's a setDate method
			return eventRepository.save(existingEvent);
		}
		return null;
	}
}
