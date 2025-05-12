package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.CategoriaAlimentoDto;

import java.util.List;

public interface ICategoriaAlimentoService {
    CategoriaAlimentoDto registrarCategoria(CategoriaAlimentoDto categoriaDto);
    CategoriaAlimentoDto actualizarCategoria(CategoriaAlimentoDto categoriaDto);
    void eliminarCategoria(Long idCategoria);
    List<CategoriaAlimentoDto> listarCategorias();
}
