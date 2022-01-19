package com.coderclub.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	String name;
	
	int imdb_rating;
	
	Name director;
}
