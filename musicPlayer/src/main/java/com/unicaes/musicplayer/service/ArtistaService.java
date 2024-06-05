package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.model.Artista;
import com.unicaes.musicplayer.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Artista> getAllArtistas() {
        return artistaRepository.findAll();
    }

    public Artista getArtistaById(Long id) {
        Optional<Artista> artistaOptional = artistaRepository.findById(id);
        return artistaOptional.orElse(null);
    }

    public Artista createArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    public Artista editArtista(Long id, Artista artistaDetails) {
        Optional<Artista> artistaOptional = artistaRepository.findById(id);
        if (artistaOptional.isPresent()) {
            Artista artista = artistaOptional.get();
            artista.setNombre(artistaDetails.getNombre());
            artista.setImagen(artistaDetails.getImagen());
            return artistaRepository.save(artista);
        } else {
            return null;
        }
    }

    public void deleteArtista(Long id) {
        artistaRepository.deleteById(id);
    }
}
