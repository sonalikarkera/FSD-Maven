package com.inheritance.InheritanceDemo.model.subclass;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE_DIRECTORY")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	public Employee() {

	}

}