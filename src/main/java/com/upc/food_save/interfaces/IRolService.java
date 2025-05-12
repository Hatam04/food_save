package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.RolDto;

import java.util.List;

public interface IRolService {
    RolDto registrarRol(RolDto dto);
    RolDto actualizarRol(RolDto dto);
    void eliminarRol(Long idRol);
    List<RolDto> listarRoles();
}
