package com.flavio.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flavio.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
