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

    public Cancion getCancionById(Long id) {
        return cancionRepository.findById(id).orElse(null);
    }

    public Cancion saveCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }

    public Cancion updateCancion(Long id, Cancion cancion) {
        Cancion existingCancion = cancionRepository.findById(id).orElse(null);
        if (existingCancion != null) {
            existingCancion.setNombre(cancion.getNombre());
            existingCancion.setImagen(cancion.getImagen());
            existingCancion.setArchivo(cancion.getArchivo());
            existingCancion.setArtista(cancion.getArtista());
            return cancionRepository.save(existingCancion);
        }
        return null;
    }
}
