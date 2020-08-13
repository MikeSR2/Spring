package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dao.VideojuegoDao;
import com.example.demo.models.documents.Videojuego;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Contolador simple rest
 * @author shepard
 *
 */
@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoRestController {
	
	@Autowired
	private VideojuegoDao videojuegosDao;

	
	/**
	 * Obttiene todos los elementos
	 * @return
	 */
	@GetMapping()
	public Flux<Videojuego> index(){
		Flux<Videojuego> videojuegos=videojuegosDao.findAll().map(videojuego -> {
			videojuego.setNombre(videojuego.getNombre().toUpperCase());
			return videojuego;
		}).doOnNext(juego -> System.out.println("Nombre :: ".concat(juego.getNombre())));
		
		return videojuegos;
	}
	
	/**
	 * obtiene el elemento por id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Mono<Videojuego> verProducto(@PathVariable String id){
		return videojuegosDao.findById(id);
		
	}
}
