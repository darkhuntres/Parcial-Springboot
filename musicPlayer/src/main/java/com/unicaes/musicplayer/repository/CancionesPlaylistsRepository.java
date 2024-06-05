package com.unicaes.musicplayer.repository;

import com.unicaes.musicplayer.model.CancionesPlaylists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionesPlaylistsRepository extends JpaRepository<CancionesPlaylists, Long> {
}
