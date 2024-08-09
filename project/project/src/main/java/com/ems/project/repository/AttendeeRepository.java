package com.ems.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// Ensure your Attendee class is in the correct package or imported correctly

import com.ems.project.entity.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, Long>{
	
}
