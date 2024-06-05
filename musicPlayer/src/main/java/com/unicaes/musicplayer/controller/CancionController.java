package com.unicaes.musicplayer.controller;

import com.unicaes.musicplayer.model.Cancion;
import com.unicaes.musicplayer.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cancion")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @GetMapping("/all")
    public List<Cancion> getAllCanciones() {
        return cancionService.getAllCanciones();
    }

    @PostMapping("/create")
    public ResponseEntity<Cancion> createCancion(@RequestBody Cancion cancion) {
        Cancion createdCancion = cancionService.createCancion(cancion);
        return new ResponseEntity<>(createdCancion, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCancion(@PathVariable Long id) {
        cancionService.deleteCancion(id);
    }
}
