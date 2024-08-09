package com.ems.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 // Ensure your Organizer class is in the correct package or imported correctly

import com.ems.project.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long>{
	
}
