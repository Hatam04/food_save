package com.upc.food_save.services;

import com.upc.food_save.dtos.RetoSemanalDto;
import com.upc.food_save.entities.RetoSemanal;
import com.upc.food_save.interfaces.IRetoSemanalService;
import com.upc.food_save.repositories.RetoSemanalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetoSemanalService implements IRetoSemanalService {
    @Autowired
    private RetoSemanalRepository retoSemanalRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RetoSemanalDto registrarReto(RetoSemanalDto dto) {
        RetoSemanal reto = modelMapper.map(dto, RetoSemanal.class);
        return modelMapper.map(retoSemanalRepository.save(reto), RetoSemanalDto.class);
    }

    @Override
    public RetoSemanalDto actualizarReto(RetoSemanalDto dto) {
        RetoSemanal existente = retoSemanalRepository.findById(dto.getId_reto_semanal())
                .orElseThrow(() -> new RuntimeException("Reto no encontrado"));

        existente.setTitulo(dto.getTitulo());
        existente.setDescripcion(dto.getDescripcion());
        existente.setFecha_inicio(dto.getFecha_inicio());
        existente.setFecha_fin(dto.getFecha_fin());
        existente.setNivel_dificultad(dto.getNivel_dificultad());

        return modelMapper.map(retoSemanalRepository.save(existente), RetoSemanalDto.class);
    }

    @Override
    public void eliminarReto(Long idReto) {
        retoSemanalRepository.deleteById(idReto);
    }

    @Override
    public List<RetoSemanalDto> listarRetos() {
        return retoSemanalRepository.findAll().stream()
                .map(r -> modelMapper.map(r, RetoSemanalDto.class))
                .collect(Collectors.toList());
    }
}
