package com.example.graphql.graphqlmongodemo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="Game")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Game {
    @Id
    private String id;
    private String title;
    private String genre;
    private String releaseDate;
    private String platform;
   

    /**
     * new game
     * @param title
     * @param genre
     * @param date
     * @param platform
     * @param guide_id
     */
    public Game(String title, String genre, String releaseDate, String platform) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.platform = platform;
    }

    
}
