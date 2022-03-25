package com.fernandosilveira.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fernandosilveira.workshopmongo.domain.Post;
import com.fernandosilveira.workshopmongo.domain.User;
import com.fernandosilveira.workshopmongo.dto.AuthorDTO;
import com.fernandosilveira.workshopmongo.dto.CommentDto;
import com.fernandosilveira.workshopmongo.repository.PostRepository;
import com.fernandosilveira.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
  
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viajem", "Vou viajar para sao paulo. Abracos!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		CommentDto c1 = new CommentDto("Boa viajem mano!", sdf.parse("21/03/2018)"), new AuthorDTO(alex));
		CommentDto c2 = new CommentDto("Aroveite", sdf.parse("23/03/2018"), new AuthorDTO(bob));
		CommentDto c3 = new CommentDto("Tenha um otimo dia", sdf.parse("23/03/2018"), new AuthorDTO());
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
				
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
				
	}
}
