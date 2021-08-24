package com.example.graphql.graphqlmongodemo.repository;

import com.example.graphql.graphqlmongodemo.model.Guide;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * guide repository
 */
public interface GuideRepository extends MongoRepository<Guide,String>{
    
}
