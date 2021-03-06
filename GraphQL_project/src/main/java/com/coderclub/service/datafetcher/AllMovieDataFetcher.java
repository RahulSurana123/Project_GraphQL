package com.coderclub.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coderclub.model.Movie;
import com.coderclub.repository.MovieRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllMovieDataFetcher implements DataFetcher<List<Movie>>{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> get(DataFetchingEnvironment environment) throws Exception {
		
		return movieRepository.findAll();
	}

}
