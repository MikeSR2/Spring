package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.example.demo.models.dao.VideojuegoDao;
import com.example.demo.models.documents.Videojuego;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SimpleSpringWebFluxAppApplication  implements CommandLineRunner{

	@Autowired
	private VideojuegoDao videojuegoDao;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemp;
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringWebFluxAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemp.dropCollection("videojuegos").subscribe();
		Flux.just(new Videojuego("Halo", Arrays.asList("Xbox","Windows"), "Bungie", "Microsoft"),
				new Videojuego("Mass Effect", Arrays.asList("Xbox 360","Windows","PS3"), "BioWare", "EA"),
				new Videojuego("Darksiders", Arrays.asList("Xbox 360","Windows","PS3"), "Nordic", "THQ"),
				new Videojuego("DOOM", Arrays.asList("Xbox One","Windows","PS4","Switch"), "ID", "Bethesda"),
				new Videojuego("Destiny", Arrays.asList("Xbox One","PS4"), "Bungie", "Activision")).
		flatMap(videojuego -> videojuegoDao.save(videojuego)).
		subscribe(producto -> System.out.println(producto.getNombre().concat(" :: guardado.")));
		
	}

}
