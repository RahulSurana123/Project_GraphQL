package com.coderclub.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coderclub.model.Movie;
import com.coderclub.repository.MovieRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetMovieDataFetcher implements DataFetcher<Movie>{

	@Autowired
	private MovieRepository movieRepo;
	
	@SuppressWarnings("deprecation")
	@Override
	public Movie get(DataFetchingEnvironment environment) throws Exception {
		
		String id = environment.getArgument("id");
		
		return movieRepo.getById(id);
	}

}
