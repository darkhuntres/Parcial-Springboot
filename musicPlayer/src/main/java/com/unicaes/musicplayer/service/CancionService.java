package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.model.Cancion;
import com.unicaes.musicplayer.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    public List<Cancion> getAllCanciones() {
        return cancionRepository.findAll();
    }

    public Cancion getCancionById(Long id) {
        Optional<Cancion> cancionOptional = cancionRepository.findById(id);
        return cancionOptional.orElse(null);
    }

    public Cancion createCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }
}
