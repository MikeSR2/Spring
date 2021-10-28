package com.example.graphql.graphqlmongodemo.resolver;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.graphqlmongodemo.model.Game;
import com.example.graphql.graphqlmongodemo.model.Guide;
import com.example.graphql.graphqlmongodemo.repository.GameRepository;
import com.example.graphql.graphqlmongodemo.repository.GuideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver{
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GuideRepository guideRepository;

    /**
     * create a new game
     * @param title
     * @param genre
     * @param releaseDate
     * @param platform
     * @param guide_id
     * @return
     */
    public Game createGame(String title,String genre,Date releaseDate,String platform,String guide_id){
        Game game=new Game();
        game.setTitle(title);
        game.setGenre(genre);
        game.setDate(releaseDate);
        game.setPlatform(platform);

        gameRepository.save(game);
        return game;
    }

    /**
     * update an existing game
     * @param id
     * @param title
     * @param genre
     * @param releaseDate
     * @param platform
     * @return
     * @throws Exception
     */
    public Game updateGame(String id,String title,String genre,Date releaseDate,String platform) throws Exception{
        Optional<Game> optGame=gameRepository.findById(id);
        if(optGame.isPresent()){
            Game game=optGame.get();
            if(title!=null){
                game.setTitle(title);
            }
            if(genre!=null){
                game.setGenre(genre);
            }
            if(releaseDate!=null){
                game.setDate(releaseDate);
            }
            if(platform!=null){
                game.setPlatform(platform);
            }

            gameRepository.save(game);
            return game;
        }
        throw new Exception("Game not found!");
    }

    /**
     * create a new guide for a game
     * @param title
     * @param gameLenght
     * @param levels
     * @param game_id
     * @return
     * @throws Exception
     */
    public Guide createGuide(String title,int gameLenght,List<String> levels,String game_id) throws Exception{
        Optional<Game> optGame=gameRepository.findById(game_id);
        if(optGame.isPresent()){
            Guide guide=new Guide();
            guide.setTitle(title);
            guide.setGameLenght(gameLenght);
            guide.setLevels(levels);
            guide.setGame_id(game_id);

            guideRepository.save(guide);
            return guide;
        }
        throw new Exception("Game not found!");
    }

    /**
     * update a guide
     * @param id
     * @param title
     * @param gameLenght
     * @param levels
     * @return
     * @throws Exception
     */
    public Guide updateGuide(String id,String title,int gameLenght,List<String> levels) throws Exception{
        Optional<Guide> optGuide=guideRepository.findById(id);
        if(optGuide.isPresent()){
            Guide guide=optGuide.get();
            if(title!=null){
                guide.setTitle(title);
            }
            if(gameLenght<1){
                guide.setGameLenght(gameLenght);
            }
            if(levels!=null){
                guide.setLevels(levels);
            }

            guideRepository.save(guide);
            return guide;
        }
        throw new Exception("Guide not found!");
    }

    /**
     * delete a guide
     * @param id
     * @return
     */
    public boolean deleteGuide(String id){
        guideRepository.deleteById(id);
        return true;
    }
}
