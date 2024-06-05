package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.model.Cancion;
import com.unicaes.musicplayer.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    public List<Cancion> getAllCanciones() {
        return cancionRepository.findAll();
    }

    public Cancion createCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }
}