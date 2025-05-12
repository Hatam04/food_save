package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.AlimentoDto;

import java.util.List;

public interface IAlimentoService {
    AlimentoDto registrarAlimento(AlimentoDto alimentoDto);
    AlimentoDto actualizarCategoria(Long idAlimento, Long idCategoria);
    List<AlimentoDto> listarAlimentosPorUsuario(Long idUsuario);
}
