package com.inheritance.InheritanceDemo.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ac_type")
@DiscriminatorValue("AC")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String email;
	private Date purchaseDate;
	

	public Account() {
	}

	public Account(String Name, String email, Date purchaseDate) {
		this.Name = Name;
		this.email = email;
		this.purchaseDate = purchaseDate;
	}
}