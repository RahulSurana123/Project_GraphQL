package com.coderclub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Movie {
	
	@Id
	String name;
	
	@Column
	int imdb_rating;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Name director;
}
