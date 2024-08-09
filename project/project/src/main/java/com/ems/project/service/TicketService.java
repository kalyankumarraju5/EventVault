package com.ems.project.service;

import java.util.List;

import com.ems.project.entity.Ticket;

public interface TicketService {
	Ticket saveTicket(Ticket ticket);

	List<Ticket> fetchAllTickets();

	Ticket getTicketById(Long id);

	Ticket updateTicketById(Long id, Ticket ticket);

	String deleteTicketById(Long id);
}
