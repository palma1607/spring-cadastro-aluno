package br.com.unicuritiba.projectstreaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.projectstreaming.models.Documentary;

public interface DocumentaryRepository 
		extends JpaRepository<Documentary, Long> {

}
