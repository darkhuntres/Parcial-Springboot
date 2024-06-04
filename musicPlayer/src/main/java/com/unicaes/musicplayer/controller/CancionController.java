package com.unicaes.musicplayer.controller;

import com.unicaes.musicplayer.model.Cancion;
import com.unicaes.musicplayer.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cancion")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    @GetMapping("/getAll")
    public List<Cancion> getAllCanciones() {
        return cancionService.getAllCanciones();
    }

    @GetMapping("/getById/{id}")
    public Cancion getCancionById(@PathVariable Long id) {
        return cancionService.getCancionById(id);
    }

    @PostMapping("/create")
    public Cancion createCancion(@RequestBody Cancion cancion) {
        return cancionService.saveCancion(cancion);
    }

    @PutMapping("/update/{id}")
    public Cancion updateCancion(@PathVariable Long id, @RequestBody Cancion cancion) {
        return cancionService.updateCancion(id, cancion);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCancion(@PathVariable Long id) {
        cancionService.deleteCancion(id);
    }
}
