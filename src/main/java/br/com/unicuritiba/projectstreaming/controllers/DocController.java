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

import br.com.unicuritiba.projectstreaming.models.Documentary;
import br.com.unicuritiba.projectstreaming.repositories.DocumentaryRepository;

@RestController
public class DocController {

	@Autowired
	DocumentaryRepository repository;
	
	@GetMapping("/documentaries")
	public ResponseEntity<List<Documentary>> getDocumentaries(){
		return ResponseEntity.ok(repository.findAll());	
	}

	@GetMapping("/documentaries/{id}")
	public ResponseEntity<Documentary> getDocumentary(@PathVariable long id){
		return ResponseEntity.ok(repository.findById(id).get());	
	}
	
	@PostMapping("/documentaries")
	public ResponseEntity<Documentary> saveDocumentary(
			@RequestBody Documentary documentary){
		Documentary savedDocumentary = repository.save(documentary);
		return ResponseEntity.ok(savedDocumentary);
	}
	
	@DeleteMapping("/documentaries/{id}")
	public void removeDocumentary(@PathVariable long id) {
		 repository.deleteById(id);
	}
	
	@PutMapping("/documentaries/{id}")
	public ResponseEntity<Documentary> updateDocumentary(@PathVariable long id,
			@RequestBody Documentary documentary) {
		documentary.setId(id);
		Documentary savedDocumentary = repository.save(documentary);
		return ResponseEntity.ok(savedDocumentary);
	}
}
