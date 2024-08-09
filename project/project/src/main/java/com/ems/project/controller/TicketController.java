package com.ems.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.project.entity.Ticket;
import com.ems.project.service.TicketService;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@PostMapping
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}

	@GetMapping
	public List<Ticket> getAllTickets() {
		return ticketService.fetchAllTickets();
	}

	@GetMapping("/{id}")
	public Ticket getTicketById(@PathVariable("id") Long id) {
		return ticketService.getTicketById(id);
	}

	@PutMapping("/{id}")
	public Ticket updateTicket(@PathVariable("id") Long id, @RequestBody Ticket ticket) {
		return ticketService.updateTicketById(id, ticket);
	}

	@DeleteMapping("/{id}")
	public String deleteTicket(@PathVariable("id") Long id) {
		return ticketService.deleteTicketById(id);
	}
}
