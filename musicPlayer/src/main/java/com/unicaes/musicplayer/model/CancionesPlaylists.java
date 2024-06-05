package com.unicaes.musicplayer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones_playlists")
public class CancionesPlaylists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cancion")
    private Long idCancion;

    @Column(name = "id_playlist")
    private Long idPlaylist;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public Long getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Long idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
}
