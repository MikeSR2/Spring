package org.springsse.example.sseexample.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import reactor.core.publisher.Flux;
import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springsse.example.sseexample.dto.Anuncio;

@RestController
public class AnunciosController {
    private static Map<Integer, Anuncio> anunciosDummyDB=new ConcurrentHashMap<>();
    
    /**
     * nuevo anuncio
     * @param anuncio
     * @return
     */
    @PostMapping(value="/anuncios")
    public Anuncio crearAnuncio(@RequestBody Anuncio anuncio){
        
        anuncio.setInserted(System.currentTimeMillis());
        anuncio.setHora(String.format("%1$tH:%1$tM", anuncio.getInserted()));
        anunciosDummyDB.put(anunciosDummyDB.entrySet().size()+1,anuncio);
        System.out.println("New post, content: "+anuncio.toString());
        return anuncio;
    }

    /**
     * Stream de anuncios
     * @return
     */
    @GetMapping(value="/anuncios/stream", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Collection<Anuncio>>> actualizacionAnuncios() {

        return Flux.interval(Duration.ofSeconds(5))
        .map(tick -> tick == 0 ? anunciosDummyDB.values() : 
        getAnunciosNuevos())
        .map(anuncios -> ServerSentEvent.<Collection<Anuncio>> builder()
            .event("nuevo-anuncio")
            .data(anuncios)
            .build());
    }

    /**
     * obtener el ultimo anuncio insertado
     * @return
     */
    private List<Anuncio> getAnunciosNuevos(){
        LinkedList<Anuncio> updatedStocks = new LinkedList<>();
        anunciosDummyDB.values()
            .stream()
            .filter(anuncio -> anuncio.getInserted() > 
                System.currentTimeMillis() - 5000)
            .forEach(stock -> updatedStocks.add(stock));
        return updatedStocks;
        
    }
}
