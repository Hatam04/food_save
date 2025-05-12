package com.upc.food_save.controllers;

import com.upc.food_save.dtos.RetoSemanalDto;
import com.upc.food_save.interfaces.IRetoSemanalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/retos_semanales")
public class RetoSemanalController {
    @Autowired
    private IRetoSemanalService retoSemanalService;

    @PostMapping
    public ResponseEntity<RetoSemanalDto> registrar(@RequestBody RetoSemanalDto dto) {
        return ResponseEntity.ok(retoSemanalService.registrarReto(dto));
    }

    @PutMapping
    public ResponseEntity<RetoSemanalDto> actualizar(@RequestBody RetoSemanalDto dto) {
        return ResponseEntity.ok(retoSemanalService.actualizarReto(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        retoSemanalService.eliminarReto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RetoSemanalDto>> listar() {
        return ResponseEntity.ok(retoSemanalService.listarRetos());
    }
}
