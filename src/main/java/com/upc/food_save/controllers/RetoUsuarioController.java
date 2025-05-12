package com.upc.food_save.controllers;

import com.upc.food_save.dtos.RetoUsuarioDto;
import com.upc.food_save.interfaces.IRetoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/retos-usuario")
public class RetoUsuarioController {
    @Autowired
    private IRetoUsuarioService retoUsuarioService;

    @PostMapping
    public ResponseEntity<RetoUsuarioDto> inscribirse(@RequestBody RetoUsuarioDto dto) {
        return ResponseEntity.ok(retoUsuarioService.inscribirReto(dto));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<RetoUsuarioDto>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(retoUsuarioService.listarRetosPorUsuario(idUsuario));
    }
}
