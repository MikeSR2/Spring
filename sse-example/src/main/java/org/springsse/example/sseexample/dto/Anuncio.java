package org.springsse.example.sseexample.dto;

public class Anuncio {
   
    
    private String autor;
    private String anuncio;
    private String hora;
    private long inserted;

    public Anuncio(){}

    public Anuncio(String autor, String anuncio, String hora, long inserted) {
        this.autor = autor;
        this.anuncio = anuncio;
        this.hora = hora;
        this.inserted = inserted;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAnuncio() {
        return anuncio;
    }
    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public long getInserted() {
        return inserted;
    }
    public void setInserted(long inserted) {
        this.inserted = inserted;
    }
    
    @Override
    public String toString(){
        return getAutor().concat(": ").concat(getAnuncio()).concat(" - ").concat(getHora());
    }
}
