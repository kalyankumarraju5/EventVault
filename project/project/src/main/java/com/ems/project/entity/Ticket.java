package com.ems.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;
    
    @Column(name = "price")
    private int price;

    public Ticket() {
    }

    public Ticket(Long ticketId, Event event, Attendee attendee, int price) {
        this.ticketId = ticketId;
        this.event = event;
        this.attendee = attendee;
        this.price = price;
    }

	/*
	 * public Object getStatus() { // TODO Auto-generated method stub return null; }
	 * 
	 * public void setStatus(Object status) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	public void setPrice(Object price2) {
		// TODO Auto-generated method stub
		
	}

}
