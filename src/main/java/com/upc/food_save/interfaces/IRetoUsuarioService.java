package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.RetoUsuarioDto;

import java.util.List;

public interface IRetoUsuarioService {
    RetoUsuarioDto inscribirReto(RetoUsuarioDto dto);
    List<RetoUsuarioDto> listarRetosPorUsuario(Long idUsuario);
}
