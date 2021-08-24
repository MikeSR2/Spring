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
    private Date date;
    private String platform;
    private String guide_id;

    /**
     * new game
     * @param title
     * @param genre
     * @param date
     * @param platform
     * @param guide_id
     */
    public Game(String title, String genre, Date date, String platform, String guide_id) {
        this.title = title;
        this.genre = genre;
        this.date = date;
        this.platform = platform;
        this.guide_id = guide_id;
    }

    
}
