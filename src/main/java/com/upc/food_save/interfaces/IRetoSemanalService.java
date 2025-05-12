package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.RetoSemanalDto;

import java.util.List;

public interface IRetoSemanalService {
    RetoSemanalDto registrarReto(RetoSemanalDto dto);
    RetoSemanalDto actualizarReto(RetoSemanalDto dto);
    void eliminarReto(Long idReto);
    List<RetoSemanalDto> listarRetos();
}
