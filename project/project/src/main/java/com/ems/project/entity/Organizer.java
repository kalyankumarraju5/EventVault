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

/*import java.util.ArrayList;
import java.util.List;*/

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@Entity
@Table(name = "organizer")
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organizer_id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

	
	/*
	 * @OneToMany (mappedBy = "organizer")@JsonManagedReference private
	 * List<Organizer> Organizers = new ArrayList<>();
	 */
	 
	  @ManyToOne
	  @JsonBackReference
	  private Organizer organizer;
		
		public Organizer() {

		}
		 
    public Organizer(String name) {
        this.name = name;
        
    }

	/*
	 * public Object getStatus() { // TODO Auto-generated method stub return null; }
	 * 
	 * public void setStatus(Object status) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
}
