package com.unicaes.musicplayer.repository;

import com.unicaes.musicplayer.model.CancionesPlaylists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancionesPlaylistsRepository extends JpaRepository<CancionesPlaylists, Long> {
    List<CancionesPlaylists> findByIdPlaylist(Long idPlaylist);
}
