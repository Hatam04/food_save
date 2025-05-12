package com.upc.food_save.controllers;

import com.upc.food_save.dtos.InventarioAlimentoDto;
import com.upc.food_save.interfaces.IInventarioAlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioAlimentoController {
    @Autowired
    private IInventarioAlimentoService inventarioAlimentoService;

    @PostMapping("/registrar")
    public ResponseEntity<InventarioAlimentoDto> registrar(@RequestBody InventarioAlimentoDto inventarioDto) {
        return ResponseEntity.ok(inventarioAlimentoService.registrarInventario(inventarioDto));
    }

    @PutMapping("/{idInventario}")
    public ResponseEntity<InventarioAlimentoDto> actualizar(
            @PathVariable Long idInventario,
            @RequestParam int cantidadConsumida,
            @RequestParam int cantidadVencida) {
        return ResponseEntity.ok(inventarioAlimentoService.actualizarInventario(idInventario, cantidadConsumida, cantidadVencida));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<InventarioAlimentoDto>> listarInventarioUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(inventarioAlimentoService.listarInventarioPorUsuario(idUsuario));
    }
}
