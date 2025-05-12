package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.InventarioAlimentoDto;

import java.util.List;

public interface IInventarioAlimentoService {
    InventarioAlimentoDto registrarInventario(InventarioAlimentoDto inventarioDto);
    InventarioAlimentoDto actualizarInventario(Long idInventario, int cantidadConsumida, int cantidadVencida);
    List<InventarioAlimentoDto> listarInventarioPorUsuario(Long idUsuario);
}
