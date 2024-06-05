package com.unicaes.musicplayer.controller;

import com.unicaes.musicplayer.model.Artista;
import com.unicaes.musicplayer.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artista")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/all")
    public List<Artista> getAllArtistas() {
        return artistaService.getAllArtistas();
    }

    @PostMapping("/create")
    public Artista createArtista(@RequestBody Artista artista) {
        return artistaService.createArtista(artista);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtista(@PathVariable Long id) {
        artistaService.deleteArtista(id);
    }
}