package com.coderclub.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.coderclub.model.Movie;
import com.coderclub.model.Name;
import com.coderclub.model.Prefix;
import com.coderclub.repository.MovieRepository;
import com.coderclub.service.datafetcher.AllMovieDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;

@Service
public class MovieServiceImpl {

	@Autowired
	MovieRepository movieRepository;
	
	@Value("classpath:schema.graphql")
	Resource resource;

	@Autowired
	private AllMovieDataFetcher allMovieDataFetcher;
	
	private GraphQL graphQL;

	@PostConstruct
	private void loadSchema() throws IOException {
		LoadData();

		File schemaFile = resource.getFile();
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser()
				.parse(schemaFile);
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator()
				.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {

		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring.dataFetcher("allMovie", allMovieDataFetcher))
				.build();
	}

	private void LoadData() {
		Stream.of(
				new Movie("Kuch Kuch Hota he",4,new Name(Prefix.Mr,"Karan","Johar"))
				).forEach( movie -> movieRepository.save(movie));
	}
}
