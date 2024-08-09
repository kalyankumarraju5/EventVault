package com.ems.project.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Ensure your Event class is in the correct package or imported correctly

import com.ems.project.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
