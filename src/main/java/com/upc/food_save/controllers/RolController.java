package com.upc.food_save.controllers;

import com.upc.food_save.dtos.RolDto;
import com.upc.food_save.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired
    private IRolService rolService;
    @PostMapping
    public ResponseEntity<RolDto> registrar(@RequestBody RolDto dto) {
        return ResponseEntity.ok(rolService.registrarRol(dto));
    }

    @PutMapping
    public ResponseEntity<RolDto> actualizar(@RequestBody RolDto dto) {
        return ResponseEntity.ok(rolService.actualizarRol(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RolDto>> listar() {
        return ResponseEntity.ok(rolService.listarRoles());
    }
}
