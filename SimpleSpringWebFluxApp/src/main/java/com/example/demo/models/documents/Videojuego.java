package com.example.demo.models.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * modelo para la coleccion videojuegos
 * @author miguel
 *
 */
@Document(collection="videojuegos")
public class Videojuego {
	
	/**
	 * id del juego
	 */
	@Id
	private String id;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * nombre como se conoce el juego
	 */
	private String nombre;
	
	/**
	 * plataformas para las que esta disponible
	 */
	private List<String> plataformas;
	
	/**
	 * distribuidora
	 */
	private String distribuidora;
	
	/**
	 * empresa que lo desarrollo
	 */
	private String desarrolladora;
		
	
	
	/**
	 * default constructor
	 */
	public Videojuego() {
	}

	/**
	 * @param nombre
	 * @param plataformas
	 * @param distribuidora
	 * @param desarrolladora
	 */
	public Videojuego(String nombre, List<String> plataformas, String distribuidora, String desarrolladora) {
		super();
		this.nombre = nombre;
		this.plataformas = plataformas;
		this.distribuidora = distribuidora;
		this.desarrolladora = desarrolladora;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the plataformas
	 */
	public List<String> getPlataformas() {
		return plataformas;
	}

	/**
	 * @param plataformas the plataformas to set
	 */
	public void setPlataformas(List<String> plataformas) {
		this.plataformas = plataformas;
	}

	/**
	 * @return the distribuidora
	 */
	public String getDistribuidora() {
		return distribuidora;
	}

	/**
	 * @param distribuidora the distribuidora to set
	 */
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	/**
	 * @return the desarrolladora
	 */
	public String getDesarrolladora() {
		return desarrolladora;
	}

	/**
	 * @param desarrolladora the desarrolladora to set
	 */
	public void setDesarrolladora(String desarrolladora) {
		this.desarrolladora = desarrolladora;
	}

	
	
}
