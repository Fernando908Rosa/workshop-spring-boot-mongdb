package com.fernandosilveira.workshopmongo.repository;

                                                                                                                                                                 
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernandosilveira.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("('title': ( Sregex: ?0, Soptions: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContaining(String text);
	
	@Query("{ Sand: [ {date: {Sgte: ?1} }, { date: { Slte: ?2} } , { Sor: [ { 'title': { Sregex: ?0, Soptions: 'i' } }, {  'body': { Sregex: ?0, Soptions: 'i' } } { 'Comments.text': { Sregex: ?0, Soptions: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}




