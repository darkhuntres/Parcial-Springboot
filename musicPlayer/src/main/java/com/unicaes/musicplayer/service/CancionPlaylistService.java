package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.model.Cancion;
import com.unicaes.musicplayer.model.Playlist;
import com.unicaes.musicplayer.repository.CancionRepository;
import com.unicaes.musicplayer.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionPlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private CancionRepository cancionRepository;

    public List<Cancion> getAllCancionesByPlaylistId(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist != null) {
            return playlist.getCanciones();
        }
        return null;
    }

    public void addCancionToPlaylist(Long playlistId, Long cancionId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        Cancion cancion = cancionRepository.findById(cancionId).orElse(null);
        if (playlist != null && cancion != null) {
            playlist.addCancion(cancion);
            playlistRepository.save(playlist);
        }
    }

    public void removeCancionFromPlaylist(Long playlistId, Long cancionId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist != null) {
            playlist.removeCancionById(cancionId);
            playlistRepository.save(playlist);
        }
    }
}
