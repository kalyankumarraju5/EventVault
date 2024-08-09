package com.ems.project.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Ensure your Ticket class is in the correct package or imported correctly

import com.ems.project.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
