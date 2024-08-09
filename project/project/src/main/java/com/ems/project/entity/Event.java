package com.ems.project.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//import java.util.ArrayList;
//import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", length = 255)
    private String description;


	/*
	 * @OneToMany(mappedBy ="event")
	 * 
	 * @JsonManagedReference private List<Event> events = new ArrayList<>();
	 */
	
	@ManyToOne
    @JsonBackReference
	private Event event;
	
	public Event() {
		
	}
	 

    public Event(String title, String description, Long id) {
        this.title = title;
        this.description = description;
        this.id=id;
    }


}


