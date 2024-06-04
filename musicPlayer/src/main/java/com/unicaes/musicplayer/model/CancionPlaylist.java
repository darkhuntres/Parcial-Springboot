package com.unicaes.musicplayer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones_playlists")
public class CancionPlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cancion")
    private Cancion cancion;

    @ManyToOne
    @JoinColumn(name = "id_playlist")
    private Playlist playlist;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
