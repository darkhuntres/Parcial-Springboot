package com.unicaes.musicplayer.dto;

public class CancionPlaylistInfoDTO {
    private Long idCancion;
    private String imagenCancion;
    private String nombreCancion;
    private String nombreArtista;
    private String cancion;

    // Constructor
    public CancionPlaylistInfoDTO(Long idCancion, String imagenCancion, String nombreCancion, String nombreArtista, String cancion) {
        this.idCancion = idCancion;
        this.imagenCancion = imagenCancion;
        this.nombreCancion = nombreCancion;
        this.nombreArtista = nombreArtista;
        this.cancion = cancion;
    }

    // Getters y Setters

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public String getImagenCancion() {
        return imagenCancion;
    }

    public void setImagenCancion(String imagenCancion) {
        this.imagenCancion = imagenCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }
}
