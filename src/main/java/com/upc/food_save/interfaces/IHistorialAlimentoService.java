package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.HistorialAlimentoDto;

import java.util.List;

public interface IHistorialAlimentoService {
    List<HistorialAlimentoDto> listarPorUsuario(Long idUsuario);
    void registrarEvento(HistorialAlimentoDto dto);
}
