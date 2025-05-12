package com.upc.food_save.controllers;

import com.upc.food_save.dtos.CategoriaAlimentoDto;
import com.upc.food_save.interfaces.ICategoriaAlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/categorias")
public class CategoriaAlimentoController {
    @Autowired
    private ICategoriaAlimentoService categoriaAlimentoService;

    @PostMapping
    public ResponseEntity<CategoriaAlimentoDto> registrar(@RequestBody CategoriaAlimentoDto dto) {
        return ResponseEntity.ok(categoriaAlimentoService.registrarCategoria(dto));
    }

    @PutMapping
    public ResponseEntity<CategoriaAlimentoDto> actualizar(@RequestBody CategoriaAlimentoDto dto) {
        return ResponseEntity.ok(categoriaAlimentoService.actualizarCategoria(dto));
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCategoria) {
        categoriaAlimentoService.eliminarCategoria(idCategoria);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaAlimentoDto>> listar() {
        return ResponseEntity.ok(categoriaAlimentoService.listarCategorias());
    }
}
