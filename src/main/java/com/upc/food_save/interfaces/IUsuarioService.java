package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.UsuarioDto;

import java.util.List;

public interface IUsuarioService {
    UsuarioDto registrarUsuario(UsuarioDto usuarioDto);
    UsuarioDto login(String correo, String contrasenia);
    List<UsuarioDto> listarUsuarios();
}
