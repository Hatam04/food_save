package com.upc.food_save.controllers;

import com.upc.food_save.dtos.HistorialAlimentoDto;
import com.upc.food_save.interfaces.IHistorialAlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialAlimentoController {
    @Autowired
    private IHistorialAlimentoService historialService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<HistorialAlimentoDto>> listar(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(historialService.listarPorUsuario(idUsuario));
    }

    @PostMapping
    public ResponseEntity<Void> registrarEvento(@RequestBody HistorialAlimentoDto dto) {
        historialService.registrarEvento(dto);
        return ResponseEntity.ok().build();
    }
}
