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

import br.com.unicuritiba.projectstreaming.models.Serie;
import br.com.unicuritiba.projectstreaming.repositories.SerieRepository;

@RestController
public class SerieController {

	@Autowired
	SerieRepository repository;
	
	@GetMapping("/series")
	public ResponseEntity<List<Serie>> getSeries(){
		return ResponseEntity.ok(repository.findAll());	
	}

	@GetMapping("/series/{id}")
	public ResponseEntity<Serie> getSerie(@PathVariable long id){
		return ResponseEntity.ok(repository.findById(id).get());	
	}
	
	@PostMapping("/series")
	public ResponseEntity<Serie> saveSerie(
			@RequestBody Serie serie){
		Serie savedSerie = repository.save(serie);
		return ResponseEntity.ok(savedSerie);
	}
	
	@DeleteMapping("/series/{id}")
	public void removeSerie(@PathVariable long id) {
		 repository.deleteById(id);
	}
	
	@PutMapping("/series/{id}")
	public ResponseEntity<Serie> updateSerie(@PathVariable long id,
			@RequestBody Serie serie) {
		serie.setId(id);
		Serie savedSerie = repository.save(serie);
		return ResponseEntity.ok(savedSerie);
	}
}
