package com.coderclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {
	
	Prefix prefix;
	
	String firstName;
	
	String lastName;
}
