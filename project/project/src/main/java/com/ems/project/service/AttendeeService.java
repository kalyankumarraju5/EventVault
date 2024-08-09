package com.ems.project.service;

import java.util.List;

import com.ems.project.entity.Attendee;

public interface AttendeeService {
	Attendee saveAttendee(Attendee attendee);

	List<Attendee> fetchAllAttendees();

	Attendee getAttendeeById(Long id);

	Attendee updateAttendeeById(Long id, Attendee attendee);

	String deleteAttendeeId(Long id);

	Attendee save(Attendee attendee);
}
