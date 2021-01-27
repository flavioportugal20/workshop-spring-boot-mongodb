package com.flavio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.flavio.workshopmongo.domain.User;
import com.flavio.workshopmongo.repository.UserRepository;
import com.flavio.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id){
		User user = repo.findById(id).orElse(null);				 
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	
}
