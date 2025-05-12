package com.upc.food_save.controllers;

import com.upc.food_save.dtos.ReporteConsumidoAdminDto;
import com.upc.food_save.dtos.ReporteConsumoDto;
import com.upc.food_save.interfaces.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    @Autowired
    private IReporteService reporteService;

    @GetMapping("/consumo")
    public ResponseEntity<ReporteConsumoDto> generarReporte(
            @RequestParam Long idUsuario,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {

        ReporteConsumoDto dto = reporteService.generarReporteConsumo(idUsuario, desde, hasta);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/global")
    public ResponseEntity<List<ReporteConsumidoAdminDto>> reporteGlobal(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {

        return ResponseEntity.ok(reporteService.generarReporteGlobal(desde, hasta));
    }
}
