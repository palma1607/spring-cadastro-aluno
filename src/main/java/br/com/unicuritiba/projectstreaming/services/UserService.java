package br.com.unicuritiba.projectstreaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicuritiba.projectstreaming.models.User;
import br.com.unicuritiba.projectstreaming.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public List<User> getAllUser(){
		return repository.findAll();
	}
	
	public User getUserById(Long id) {
		return repository.findById(id).get();
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public void removeUser(Long id) {
		repository.deleteById(id);
	}
	
	public User updateUser(Long id, User user) {
		user.setId(id);
		return saveUser(user);
	}
}
