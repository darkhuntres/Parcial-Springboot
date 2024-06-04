package com.unicaes.musicplayer.controller;

import com.unicaes.musicplayer.service.CancionPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/playlist/{playlistId}/cancion")
public class CancionPlaylistController {

    @Autowired
    private CancionPlaylistService cancionPlaylistService;

    @PostMapping("/add/{cancionId}")
    public void addCancionToPlaylist(@PathVariable Long playlistId, @PathVariable Long cancionId) {
        cancionPlaylistService.addCancionToPlaylist(playlistId, cancionId);
    }

    @DeleteMapping("/remove/{cancionId}")
    public void removeCancionFromPlaylist(@PathVariable Long playlistId, @PathVariable Long cancionId) {
        cancionPlaylistService.removeCancionFromPlaylist(playlistId, cancionId);
    }
}
