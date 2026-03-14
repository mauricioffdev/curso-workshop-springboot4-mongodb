package com.mauricioff.workshopmongo.repository;

import com.mauricioff.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //querry method para consulta
    List<Post> findByTitleContainingIgnoreCase(String text);
}

