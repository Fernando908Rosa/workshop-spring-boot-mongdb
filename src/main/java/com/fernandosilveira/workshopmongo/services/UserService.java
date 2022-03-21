package com.fernandosilveira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosilveira.workshopmongo.domain.User;
import com.fernandosilveira.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
   public List<User> findAll() {
	   return repo.findAll();
   	}
}   
   
   
  
   