package com.fernandosilveira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosilveira.workshopmongo.domain.Post;
import com.fernandosilveira.workshopmongo.repository.PostRepository;
import com.fernandosilveira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo; 	
   
  public Post findById(String id) {
	  Post post = repo.findById(id).get();
	  if (post == null) {
		  throw new ObjectNotFoundException("Objeto nao encontrado");
	  }
	  	return post;
  	} 
  public List<Post> findByTitle(String text) {
	  return repo.searchTitle(text);
  }
}  
  
   