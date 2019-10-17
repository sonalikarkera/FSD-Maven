package com.mycompany.hiberapplication.entity;



import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student")

public class Student implements Serializable{

	private static final long serialVersionUID = -1065800768812736050L;

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String first_Name;
	@Column(name = "last_name")
	private String last_Name;
	@Column(name = "email")
	private String email;
	
	
	
}

