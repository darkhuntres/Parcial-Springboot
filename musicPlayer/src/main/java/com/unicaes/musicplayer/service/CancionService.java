package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.dto.CancionDTO;
import com.unicaes.musicplayer.model.Cancion;
import com.unicaes.musicplayer.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    public List<CancionDTO> getAllCanciones() {
        return cancionRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CancionDTO getCancionById(Long id) {
        return cancionRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public Cancion createCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }

    private CancionDTO convertToDTO(Cancion cancion) {
        CancionDTO dto = new CancionDTO();
        dto.setId(cancion.getId());
        dto.setNombre(cancion.getNombre());
        dto.setImagen(cancion.getImagen());
        dto.setCancion(cancion.getCancion());
        dto.setArtista(cancion.getArtista().getNombre());
        return dto;
    }
}
