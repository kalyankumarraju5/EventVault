package com.ems.project.service;

import java.util.List;

import com.ems.project.entity.Event;

public interface EventService {
	Event saveEvent(Event event);

	List<Event> fetchAllEvents();

	Event getEventById(Long id);

	Event updateEventById(Long id, Event event);

	String deleteEventById(Long id);
}