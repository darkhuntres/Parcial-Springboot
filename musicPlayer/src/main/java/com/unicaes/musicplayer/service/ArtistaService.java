package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.dto.ArtistaDTO;
import com.unicaes.musicplayer.model.Artista;
import com.unicaes.musicplayer.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public List<ArtistaDTO> getAllArtistas() {
        return artistaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ArtistaDTO getArtistaById(Long id) {
        return artistaRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public ArtistaDTO saveArtista(Artista artista) {
        Artista savedArtista = artistaRepository.save(artista);
        return convertToDTO(savedArtista);
    }

    public void deleteArtista(Long id) {
        artistaRepository.deleteById(id);
    }

    public ArtistaDTO updateArtista(Long id, Artista artista) {
        Artista existingArtista = artistaRepository.findById(id).orElse(null);
        if (existingArtista != null) {
            existingArtista.setNombre(artista.getNombre());
            existingArtista.setImagen(artista.getImagen());
            Artista updatedArtista = artistaRepository.save(existingArtista);
            return convertToDTO(updatedArtista);
        }
        return null;
    }

    private ArtistaDTO convertToDTO(Artista artista) {
        ArtistaDTO dto = new ArtistaDTO();
        dto.setId(artista.getId());
        dto.setNombre(artista.getNombre());
        dto.setImagen(artista.getImagen());
        return dto;
    }
}
