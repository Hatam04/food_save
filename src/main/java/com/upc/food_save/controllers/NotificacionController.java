package com.upc.food_save.controllers;

import com.upc.food_save.dtos.NotificacionDto;
import com.upc.food_save.interfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    @Autowired
    private INotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<Void> enviar(@RequestBody NotificacionDto dto) {
        notificacionService.enviarNotificacion(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<NotificacionDto>> listar(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(notificacionService.listarPorUsuario(idUsuario));
    }

    @PutMapping("/{idNotificacion}/leida")
    public ResponseEntity<Void> marcarLeida(@PathVariable Long idNotificacion) {
        notificacionService.marcarComoLeida(idNotificacion);
        return ResponseEntity.ok().build();
    }
}
