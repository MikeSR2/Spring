package com.example.graphql.graphqlmongodemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import antlr.collections.List;
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
    private List levels;
    
    /**
     * new guide
     * @param title
     * @param gameLenght
     * @param levels
     */
    public Guide(String title, int gameLenght, List levels) {
        this.title = title;
        this.gameLenght = gameLenght;
        this.levels = levels;
    }
}
