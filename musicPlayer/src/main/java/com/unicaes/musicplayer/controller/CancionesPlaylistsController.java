package com.unicaes.musicplayer.controller;

import com.unicaes.musicplayer.dto.CancionInfoDTO;
import com.unicaes.musicplayer.dto.CancionesPlaylistsDTO;
import com.unicaes.musicplayer.model.CancionesPlaylists;
import com.unicaes.musicplayer.service.CancionesPlaylistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cancionesplaylists")
public class CancionesPlaylistsController {
    @Autowired
    private CancionesPlaylistsService cancionesPlaylistsService;

    @GetMapping("/all")
    public List<CancionesPlaylists> getAllCancionesPlaylists() {
        return cancionesPlaylistsService.getAllCancionesPlaylists();
    }

    @PostMapping("/create")
    public CancionesPlaylists createCancionesPlaylists(@RequestBody CancionesPlaylists cancionesPlaylists) {
        return cancionesPlaylistsService.createCancionesPlaylists(cancionesPlaylists);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCancionesPlaylists(@PathVariable Long id) {
        cancionesPlaylistsService.deleteCancionesPlaylists(id);
    }

    @GetMapping("/playlist/{id}")
    public List<CancionesPlaylistsDTO> getCancionesPlaylistsByPlaylistId(@PathVariable Long id) {
        return cancionesPlaylistsService.getCancionesPlaylistsByPlaylistId(id);
    }

    @GetMapping("/playlist/{id}/canciones")
    public List<CancionInfoDTO> getCancionesInfoByPlaylistId(@PathVariable Long id) {
        return cancionesPlaylistsService.getCancionesInfoByPlaylistId(id);
    }
}
