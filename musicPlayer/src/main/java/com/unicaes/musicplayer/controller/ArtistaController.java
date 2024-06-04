package com.unicaes.musicplayer.controller;

import com.unicaes.musicplayer.dto.ArtistaDTO;
import com.unicaes.musicplayer.model.Artista;
import com.unicaes.musicplayer.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/artista")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/getAll")
    public List<ArtistaDTO> getAllArtistas() {
        return artistaService.getAllArtistas();
    }

    @GetMapping("/getById/{id}")
    public ArtistaDTO getArtistaById(@PathVariable Long id) {
        return artistaService.getArtistaById(id);
    }

    @PostMapping("/create")
    public ArtistaDTO createArtista(@RequestBody Artista artista) {
        // Crear un nuevo artista solo con los campos requeridos
        Artista newArtista = new Artista();
        newArtista.setNombre(artista.getNombre());
        newArtista.setImagen(artista.getImagen());
        return artistaService.saveArtista(newArtista);
    }

    @PutMapping("/update/{id}")
    public ArtistaDTO updateArtista(@PathVariable Long id, @RequestBody Artista artista) {
        return artistaService.updateArtista(id, artista);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtista(@PathVariable Long id) {
        artistaService.deleteArtista(id);
    }
}
