package com.inheritance.InheritanceDemo.model;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Savings")
public class Savings extends Account {
	private double balance;

	public Savings() {
		super();
	}
	public Savings(String Name, String email, Date purchaseDate, double balance) {
		super(Name, email, purchaseDate);
		this.balance=balance;
		
	}
}