package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.ReporteConsumidoAdminDto;
import com.upc.food_save.dtos.ReporteConsumoDto;

import java.time.LocalDate;
import java.util.List;

public interface IReporteService {
    ReporteConsumoDto generarReporteConsumo(Long idUsuario, LocalDate desde, LocalDate hasta);
    List<ReporteConsumidoAdminDto> generarReporteGlobal(LocalDate desde, LocalDate hasta);
}
