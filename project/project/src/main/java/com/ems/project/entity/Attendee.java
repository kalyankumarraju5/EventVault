package com.ems.project.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import java.util.List;

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

@Getter
@Setter
@Entity
@Table(name = "attendee")
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendee_id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

	
	/*
	 * @OneToMany(mappedBy = "attendee")
	 * 
	 * @JsonManagedReference private List<Attendee> attendees;
	 */
	 
	@ManyToOne
    @JsonBackReference
	private Attendee attendee;
	
    public Attendee() {
    }

    public Attendee(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id=id;
    }

	/*
	 * public Object getStatus() { // TODO Auto-generated method stub return null; }
	 * 
	 * public void setStatus(Object status) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
}
