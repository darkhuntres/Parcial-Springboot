package com.unicaes.musicplayer.repository;

import com.unicaes.musicplayer.model.CancionPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionPlaylistRepository extends JpaRepository<CancionPlaylist, Long> {
}
