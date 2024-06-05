package com.unicaes.musicplayer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones_playlists")
public class CancionesPlaylists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cancion;

    private Long id_playlist;

    // Getters y Setters

    public Long getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(Long id_cancion) {
        this.id_cancion = id_cancion;
    }

    public Long getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(Long id_playlist) {
        this.id_playlist = id_playlist;
    }
}
