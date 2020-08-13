/**
 * 
 */
package com.example.demo.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.models.documents.Videojuego;

/**
 * Simple reactive drepository 
 * @author shepard
 *
 */
public interface VideojuegoDao extends ReactiveMongoRepository<Videojuego,String> {

}
