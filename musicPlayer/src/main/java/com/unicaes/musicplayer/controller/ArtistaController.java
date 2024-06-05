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

    @GetMapping("/{id}")
    public ResponseEntity<Artista> getArtistaById(@PathVariable Long id) {
        Artista artista = artistaService.getArtistaById(id);
        return ResponseEntity.ok().body(artista);
    }

    @PostMapping("/create")
    public Artista createArtista(@RequestBody Artista artista) {
        return artistaService.createArtista(artista);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Artista> editArtista(@PathVariable Long id, @RequestBody Artista artista) {
        Artista updatedArtista = artistaService.editArtista(id, artista);
        return ResponseEntity.ok().body(updatedArtista);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtista(@PathVariable Long id) {
        artistaService.deleteArtista(id);
    }
}
