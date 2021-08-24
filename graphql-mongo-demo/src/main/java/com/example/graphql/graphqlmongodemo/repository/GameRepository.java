package com.example.graphql.graphqlmongodemo.repository;
import com.example.graphql.graphqlmongodemo.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Game repository
 */
public interface GameRepository extends MongoRepository<Game,String> {
    
}
