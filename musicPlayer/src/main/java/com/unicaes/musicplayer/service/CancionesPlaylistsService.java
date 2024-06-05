package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.model.CancionesPlaylists;
import com.unicaes.musicplayer.repository.CancionesPlaylistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionesPlaylistsService {
    @Autowired
    private CancionesPlaylistsRepository cancionesPlaylistsRepository;

    public List<CancionesPlaylists> getAllCancionesPlaylists() {
        return cancionesPlaylistsRepository.findAll();
    }

    public CancionesPlaylists createCancionesPlaylists(CancionesPlaylists cancionesPlaylists) {
        return cancionesPlaylistsRepository.save(cancionesPlaylists);
    }

    public void deleteCancionesPlaylists(Long id) {
        cancionesPlaylistsRepository.deleteById(id);
    }

    public List<CancionesPlaylists> getCancionesPlaylistsByPlaylistId(Long idPlaylist) {
        return cancionesPlaylistsRepository.findByIdPlaylist(idPlaylist);
    }
}
