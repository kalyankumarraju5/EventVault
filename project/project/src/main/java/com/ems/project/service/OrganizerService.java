package com.ems.project.service;

import java.util.List;

import com.ems.project.entity.Organizer;

public interface OrganizerService {

	Organizer saveOrganizer(Organizer organizer);

	List<Organizer> fetchAllOrganizers();

	Organizer getOrganizerById(Long id);

	Organizer updateOrganizerById(Long id, Organizer organizer);

	String deleteOrganizerById(Long id);
}
