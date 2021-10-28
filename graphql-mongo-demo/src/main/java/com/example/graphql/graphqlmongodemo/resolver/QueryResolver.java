package com.example.graphql.graphqlmongodemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.graphqlmongodemo.model.Game;
import com.example.graphql.graphqlmongodemo.model.Guide;
import com.example.graphql.graphqlmongodemo.repository.GameRepository;
import com.example.graphql.graphqlmongodemo.repository.GuideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * query resolver 
 */
@Component
public class QueryResolver implements GraphQLQueryResolver{

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GuideRepository guideRepository;

    public Iterable<Game> findAllGames(){
        return gameRepository.findAll();
    }

    public Iterable<Guide> findAllGuides(){
        return guideRepository.findAll();
    }

    public long countGames(){
        return gameRepository.count();
    }

    public long countGuides(){
        return guideRepository.count();
    }

    
}
