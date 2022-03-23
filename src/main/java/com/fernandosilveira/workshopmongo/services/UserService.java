package com.fernandosilveira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosilveira.workshopmongo.domain.User;
import com.fernandosilveira.workshopmongo.dto.UserDTO;
import com.fernandosilveira.workshopmongo.repository.UserRepository;
import com.fernandosilveira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
   public List<User> findAll() {
	   return repo.findAll();
   	}
   
  public User findById(String id) {
	  User user = repo.findOne(id);
	  if (user == null) {
		  throw new ObjectNotFoundException("Objeto nao encontrado");
	  }
	  	return user;
 	
  } 
  
  public User insert(User obj) {
	  return repo.insert(obj);
  	}
  
  public void delete(String id) {
	  findById(id);
	  repo.delete(id);
  }
  
  public User fromDTO(UserDTO objDto) {
	  return new User(objDto.getId(), objDto.getName(), objDto.getEmail());	  
  	}
}   
   
  
   