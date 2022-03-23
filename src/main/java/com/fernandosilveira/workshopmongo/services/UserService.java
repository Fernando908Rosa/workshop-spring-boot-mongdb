package com.fernandosilveira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosilveira.workshopmongo.domain.Post;
import com.fernandosilveira.workshopmongo.domain.User;
import com.fernandosilveira.workshopmongo.dto.UserDTO;
import com.fernandosilveira.workshopmongo.repository.UserRepository;
import com.fernandosilveira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
   public List<User> findAll() {
	   return repository.findAll();
   	}
   
  public User findById(String id) {
	  Optional<User> user = repository.findById(id);
	  if (user == null) {
		  throw new ObjectNotFoundException("Objeto nao encontrado");
	  }
	  	return user.get();
 	
  } 
  
  public User insert(User obj) {
	  return repository.insert(obj);
  	}
  
  public void delete(String id) {
	  findById(id);
	  repository.deleteById(id);
  }
  
  public User update(User obj) {
	  User newobj = repository.findById(obj.getId()).get();
	  updateData(newobj, obj);
	  return repository.save(newobj);
	  
  }
  
  private void updateData(User newobj, User obj) {
	 newobj.setName(obj.getName());
	 newobj.setEmail(obj.getEmail());
}

public User fromDTO(UserDTO objDto) {
	  return new User(objDto.getId(), objDto.getName(), objDto.getEmail());	  
  	}
}   
   
  
   