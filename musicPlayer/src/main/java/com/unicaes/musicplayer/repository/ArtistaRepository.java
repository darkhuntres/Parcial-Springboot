package com.unicaes.musicplayer.repository;

import com.unicaes.musicplayer.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}