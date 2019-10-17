package com.inheritance.InheritanceDemo.model;


import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Current")
public class Current extends Account {
	private double balance;
	private double limitt;
	public Current() {
		super();
	}

	public Current(String Name, String email, Date purchaseDate,double limitt,double balance) {
		super(Name, email, purchaseDate);
		this.balance=balance;
		this.limitt=limitt;
	}
}