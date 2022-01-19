package com.coderclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderclub.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String>{
	
}
