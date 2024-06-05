package com.unicaes.musicplayer.repository;

import com.unicaes.musicplayer.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
