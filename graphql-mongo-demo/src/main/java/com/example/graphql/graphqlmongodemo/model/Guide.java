package com.example.graphql.graphqlmongodemo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="Guide")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Guide {

    @Id
    private String id;
    private String title;
    private int gameLenght;
    private List<String> levels;
    private String game_id;
    
    /**
     * new guide
     * @param title
     * @param gameLenght
     * @param levels
     */
    public Guide(String title, int gameLenght, List<String> levels, String game_id) {
        this.title = title;
        this.gameLenght = gameLenght;
        this.levels = levels;
        this.game_id=game_id;
    }
}
