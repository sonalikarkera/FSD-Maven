package com.hiberMapping.MappingApp.event;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructorDetailsId")
	private InstructorDetails instructorDetailsId;
	
public Instructor() {
		
	}

	public Instructor(String firstName, String lastName, String email) {
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", email=" + email
				+ ", instructorDetail=" + instructorDetailsId + "]";
	}
	

}