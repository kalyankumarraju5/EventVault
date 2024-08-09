package com.ems.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.project.entity.Ticket;
import com.ems.project.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> fetchAllTickets() {
		List<Ticket> allTickets = ticketRepository.findAll();
		return allTickets;
	}

	@Override
	public Ticket getTicketById(Long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		return ticket.orElse(null);
	}

	@Override
	public Ticket updateTicketById(Long id, Ticket ticket) {
		Optional<Ticket> ticketData = ticketRepository.findById(id);
		if (ticketData.isPresent()) {
			Ticket existingTicket = ticketData.get();
			
			if (ticket.getPrice() != 0) { // Assuming there is a getPrice method in Ticket
				existingTicket.setPrice(ticket.getPrice()); // Update the price
			}
			/*
			 * if (ticket.getStatus() != null) { // Assuming there is a getStatus method in
			 * Ticket existingTicket.setStatus(ticket.getStatus()); // Update the status }
			 */

			return ticketRepository.save(existingTicket); // Save and return the updated ticket
		}
		return null; // Return null if no ticket found with the provided ID
	}

	@Override
	public String deleteTicketById(Long id) {
		if (ticketRepository.findById(id).isPresent()) {
			ticketRepository.deleteById(id);
			return "Ticket deleted successfully";
		}
		return "No such ticket in the database";
	}
}
