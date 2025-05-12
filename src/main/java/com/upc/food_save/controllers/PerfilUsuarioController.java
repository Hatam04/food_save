package com.upc.food_save.controllers;

import com.upc.food_save.dtos.PerfilUsuarioDto;
import com.upc.food_save.interfaces.IPerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilUsuarioController {
    @Autowired
    private IPerfilUsuarioService perfilUsuarioService;

    @PutMapping("/actualizar")
    public ResponseEntity<PerfilUsuarioDto> actualizar(@RequestBody PerfilUsuarioDto dto) {
        return ResponseEntity.ok(perfilUsuarioService.actualizarPerfil(dto));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<PerfilUsuarioDto> obtener(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(perfilUsuarioService.obtenerPerfilPorUsuario(idUsuario));
    }
}
