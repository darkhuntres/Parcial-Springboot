package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.model.Artista;
import com.unicaes.musicplayer.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Artista> getAllArtistas() {
        return artistaRepository.findAll();
    }

    public Artista createArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    public void deleteArtista(Long id) {
        artistaRepository.deleteById(id);
    }
}