package com.coderclub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table
@Entity
public class Name {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	
	Prefix prefix;
	
	String firstName;
	
	String lastName;

	public Name(Prefix prefix, String firstName, String lastName) {
		super();
		this.prefix = prefix;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
