package com.example.graphql.graphqlmongodemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.graphqlmongodemo.model.Game;
import com.example.graphql.graphqlmongodemo.model.Guide;
import com.example.graphql.graphqlmongodemo.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GuideResolver implements GraphQLResolver<Guide> {
    @Autowired
    private GameRepository gameRepository;
    
    /**
     * get game from guides
     * @param guide
     * @return
     */
    public Game getGame(Guide guide){
        return gameRepository.findById(guide.getGame()).orElseThrow(null);
    }
}
