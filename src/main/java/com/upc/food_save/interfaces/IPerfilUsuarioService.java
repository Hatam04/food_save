package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.PerfilUsuarioDto;

public interface IPerfilUsuarioService {
    PerfilUsuarioDto actualizarPerfil(PerfilUsuarioDto perfilDto);
    PerfilUsuarioDto obtenerPerfilPorUsuario(Long idUsuario);
}
