package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.model.Playlist;
import com.unicaes.musicplayer.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(Long id) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(id);
        return playlistOptional.orElse(null);
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist editPlaylist(Long id, Playlist newPlaylistData) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        if (optionalPlaylist.isPresent()) {
            Playlist existingPlaylist = optionalPlaylist.get();
            existingPlaylist.setNombre(newPlaylistData.getNombre());
            existingPlaylist.setImagen(newPlaylistData.getImagen());
            return playlistRepository.save(existingPlaylist);
        } else {
            return null;
        }
    }

    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
