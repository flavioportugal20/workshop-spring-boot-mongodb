package com.flavio.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flavio.workshopmongo.domain.User;
import com.flavio.workshopmongo.dto.UserDTO;
import com.flavio.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity <List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	

}
