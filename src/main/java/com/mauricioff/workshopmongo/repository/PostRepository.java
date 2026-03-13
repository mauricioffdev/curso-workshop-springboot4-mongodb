package com.mauricioff.workshopmongo.repository;

import com.mauricioff.workshopmongo.domain.Post;
import com.mauricioff.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}

