package com.unicaes.musicplayer.dto;

public class CancionInfoDTO {
    private Long id;
    private String nombre;
    private String imagen;
    private String artista;
    private String cancionArchivo;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCancionArchivo() {
        return cancionArchivo;
    }

    public void setCancionArchivo(String cancionArchivo) {
        this.cancionArchivo = cancionArchivo;
    }
}
