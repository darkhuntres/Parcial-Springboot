package com.unicaes.musicplayer.controller;

import com.unicaes.musicplayer.model.Playlist;
import com.unicaes.musicplayer.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/all")
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @PostMapping("/create")
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }
}