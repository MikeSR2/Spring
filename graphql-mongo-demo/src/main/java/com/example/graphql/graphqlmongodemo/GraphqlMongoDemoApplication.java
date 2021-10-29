package com.example.graphql.graphqlmongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GraphqlMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlMongoDemoApplication.class, args);
	}

}
