package com.unicaes.musicplayer.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Cambiado de int a Long
    private String nombre;
    private String imagen;

    @ManyToMany
    @JoinTable(
            name = "canciones_playlists",
            joinColumns = @JoinColumn(name = "id_playlist"),
            inverseJoinColumns = @JoinColumn(name = "id_cancion")
    )
    private List<Cancion> canciones;

    // Métodos para agregar y eliminar canciones
    public void addCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }

    public void removeCancionById(Long cancionId) {
        this.canciones.removeIf(c -> c.getId().equals(cancionId));
    }

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

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
