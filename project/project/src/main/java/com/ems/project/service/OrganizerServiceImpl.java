package com.ems.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.project.entity.Organizer;
import com.ems.project.repository.OrganizerRepository;

@Service
public class OrganizerServiceImpl implements OrganizerService {
	@Autowired
	private OrganizerRepository organizerRepository;

	@Override
	public Organizer saveOrganizer(Organizer organizer) {
		return organizerRepository.save(organizer);
	}

	@Override
	public List<Organizer> fetchAllOrganizers() {
		List<Organizer> allOrganizers = organizerRepository.findAll();
		return allOrganizers;
	}

	@Override
	public Organizer getOrganizerById(Long id) {
		Optional<Organizer> organizer = organizerRepository.findById(id);
		return organizer.orElse(null);
	}

	@Override
	public Organizer updateOrganizerById(Long id, Organizer organizer) {
		Optional<Organizer> organizerData = organizerRepository.findById(id);
		if (organizerData.isPresent()) {
			Organizer existingOrganizer = organizerData.get();
			existingOrganizer.setName(organizer.getName());
			/*
			 * if (organizer.getStatus() != null) { // Assuming there is a getStatus method
			 * in Organizer existingOrganizer.setStatus(organizer.getStatus()); // Update
			 * the status }
			 */

			return organizerRepository.save(existingOrganizer); // Save and return the updated organizer
		}
		return null; // Return null if no organizer found with the provided ID
	}

	@Override
	public String deleteOrganizerById(Long id) {
		if (organizerRepository.findById(id).isPresent()) {
			organizerRepository.deleteById(id);
			return "Organizer deleted successfully";
		}
		return "No such organizer in the database";
	}
}
