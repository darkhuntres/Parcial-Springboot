package com.unicaes.musicplayer.service;

import com.unicaes.musicplayer.dto.CancionInfoDTO;
import com.unicaes.musicplayer.dto.CancionesPlaylistsDTO;
import com.unicaes.musicplayer.model.Cancion;
import com.unicaes.musicplayer.model.CancionesPlaylists;
import com.unicaes.musicplayer.repository.CancionRepository;
import com.unicaes.musicplayer.repository.CancionesPlaylistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CancionesPlaylistsService {
    @Autowired
    private CancionesPlaylistsRepository cancionesPlaylistsRepository;

    @Autowired
    private CancionRepository cancionRepository;

    public List<CancionesPlaylists> getAllCancionesPlaylists() {
        return cancionesPlaylistsRepository.findAll();
    }

    public CancionesPlaylists createCancionesPlaylists(CancionesPlaylists cancionesPlaylists) {
        return cancionesPlaylistsRepository.save(cancionesPlaylists);
    }

    public void deleteCancionesPlaylists(Long id) {
        cancionesPlaylistsRepository.deleteById(id);
    }

    public List<CancionesPlaylistsDTO> getCancionesPlaylistsByPlaylistId(Long idPlaylist) {
        List<CancionesPlaylists> cancionesPlaylists = cancionesPlaylistsRepository.findByIdPlaylist(idPlaylist);
        return cancionesPlaylists.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CancionesPlaylistsDTO convertToDTO(CancionesPlaylists cancionesPlaylists) {
        CancionesPlaylistsDTO dto = new CancionesPlaylistsDTO();
        dto.setId(cancionesPlaylists.getId());
        dto.setIdPlaylist(cancionesPlaylists.getIdPlaylist());
        Cancion cancion = cancionRepository.findById(cancionesPlaylists.getIdCancion()).orElse(null);
        if (cancion != null) {
            dto.setNombreCancion(cancion.getNombre());
        }
        return dto;
    }

    public List<CancionInfoDTO> getCancionesInfoByPlaylistId(Long idPlaylist) {
        List<CancionesPlaylists> cancionesPlaylists = cancionesPlaylistsRepository.findByIdPlaylist(idPlaylist);
        return cancionesPlaylists.stream()
                .map(cp -> {
                    Cancion cancion = cancionRepository.findById(cp.getIdCancion()).orElse(null);
                    if (cancion != null) {
                        CancionInfoDTO dto = new CancionInfoDTO();
                        dto.setCancionArchivo(cancion.getCancion());
                        dto.setCancionImagen(cancion.getImagen());
                        dto.setCancionNombre(cancion.getNombre());
                        return dto;
                    }
                    return null;
                })
                .filter(dto -> dto != null)
                .collect(Collectors.toList());
    }
}
