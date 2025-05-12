package com.upc.food_save.controllers;

import com.upc.food_save.dtos.AlimentoDto;
import com.upc.food_save.interfaces.IAlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoControlller {
    @Autowired
    private IAlimentoService alimentoService;

    @PostMapping
    public ResponseEntity<AlimentoDto> registrar(@RequestBody AlimentoDto alimentoDto) {
        return ResponseEntity.ok(alimentoService.registrarAlimento(alimentoDto));
    }

    @PutMapping("/{idAlimento}/categoria/{idCategoria}")
    public ResponseEntity<AlimentoDto> actualizarCategoria(@PathVariable Long idAlimento, @PathVariable Long idCategoria) {
        return ResponseEntity.ok(alimentoService.actualizarCategoria(idAlimento, idCategoria));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<AlimentoDto>> listarAlimentosUsuario(@PathVariable Long id_usuario) {
        return ResponseEntity.ok(alimentoService.listarAlimentosPorUsuario(id_usuario));
    }
}
