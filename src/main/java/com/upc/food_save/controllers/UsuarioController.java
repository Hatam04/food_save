package com.upc.food_save.controllers;

import com.upc.food_save.dtos.UsuarioDto;
import com.upc.food_save.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @PostMapping("/registro")

    public ResponseEntity<UsuarioDto> registrar(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuarioDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestParam String correo, @RequestParam String contrasenia) {
        return ResponseEntity.ok(usuarioService.login(correo, contrasenia));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }  @Autowired
    private IUsuarioService usuarioService;

}
