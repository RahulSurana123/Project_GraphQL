package com.coderclub.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderclub.service.MovieServiceImpl;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	@PostMapping
    public ResponseEntity<Object> getAllMovies(@RequestBody String query) {
		
        ExecutionResult execute = movieServiceImpl.getGraphQL().execute(query);

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
	
}
