package com.unicaes.musicplayer.repository;

import com.unicaes.musicplayer.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
}