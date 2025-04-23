package br.com.unicuritiba.projectstreaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.projectstreaming.models.Movie;
import br.com.unicuritiba.projectstreaming.repositories.MovieRepository;

@RestController
public class MovieController {

	@Autowired
	MovieRepository repository;
	
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getMovies(){
		return ResponseEntity.ok(repository.findAll());	
	}

	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable long id){
		return ResponseEntity.ok(repository.findById(id).get());	
	}
	
	@PostMapping("/movies")
	public ResponseEntity<Movie> saveMovie(
			@RequestBody Movie movie){
		Movie savedMovie = repository.save(movie);
		return ResponseEntity.ok(savedMovie);
	}
	
	@DeleteMapping("/movies/{id}")
	public void removeMovie(@PathVariable long id) {
		 repository.deleteById(id);
	}
	
	@PutMapping("/movies/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable long id,
			@RequestBody Movie movie) {
		movie.setId(id);
		Movie savedMovie = repository.save(movie);
		return ResponseEntity.ok(savedMovie);
	}
}
