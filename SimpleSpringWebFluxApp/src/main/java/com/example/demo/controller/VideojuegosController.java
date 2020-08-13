package com.example.demo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.example.demo.models.dao.VideojuegoDao;
import com.example.demo.models.documents.Videojuego;

import reactor.core.publisher.Flux;

/**
 * Controlador simple para las peticiones desde thymeleaf
 * @author shepard
 *
 */
@Controller
public class VideojuegosController {
	
	@Autowired
	private VideojuegoDao videojuegoDao;
	
	/**
	 * Lista todos los elementos
	 * @param model
	 * @return
	 */
	@GetMapping({"/listar","/"})
	public String listar(Model model) {
		Flux<Videojuego> videojuegos=videojuegoDao.findAll().map(videojuego -> {
			videojuego.setNombre(videojuego.getNombre().toUpperCase());
			return videojuego;
		});
		
		videojuegos.subscribe(videojuego -> System.out.println("Contolador:: nombre:: ".concat(videojuego.getNombre())));
		
		model.addAttribute("videojuegos",videojuegos);
		model.addAttribute("titulo","Lista de videojuegos");
		return "listar";
	}
	
	
	/**
	 * lista todos los elementos con delay de un segundo
	 * @param model
	 * @return
	 */
	@GetMapping({"/listar-datadriver"})
	public String listarDataDriver(Model model) {
		Flux<Videojuego> videojuegos=videojuegoDao.findAll().map(videojuego -> {
			videojuego.setNombre(videojuego.getNombre().toUpperCase());
			return videojuego;
		}).delayElements(Duration.ofSeconds(1));
		
		videojuegos.subscribe(videojuego -> System.out.println("Contolador:: nombre:: ".concat(videojuego.getNombre())));
		
		model.addAttribute("videojuegos",new ReactiveDataDriverContextVariable(videojuegos,2));
		model.addAttribute("titulo","Lista de videojuegos");
		return "listar";
	}
	
	/**
	 * muestra los elementos con un buffer establecido en el properties.
	 * @param model
	 * @return
	 */
	@GetMapping({"/listar-full"})
	public String listarFull(Model model) {
		Flux<Videojuego> videojuegos=videojuegoDao.findAll().map(videojuego -> {
			videojuego.setNombre(videojuego.getNombre().toUpperCase());
			return videojuego;
		}).repeat(5000);
		
		videojuegos.subscribe(videojuego -> System.out.println("Contolador:: nombre:: ".concat(videojuego.getNombre())));
		
		model.addAttribute("videojuegos",new ReactiveDataDriverContextVariable(videojuegos,2));
		model.addAttribute("titulo","Lista de videojuegos");
		return "listar";
	}
}
