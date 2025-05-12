package com.upc.food_save.services;

import com.upc.food_save.dtos.CategoriaAlimentoDto;
import com.upc.food_save.entities.CategoriaAlimento;
import com.upc.food_save.interfaces.ICategoriaAlimentoService;
import com.upc.food_save.repositories.CategoriaAlimentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaAlimentoService implements ICategoriaAlimentoService {
    @Autowired
    private CategoriaAlimentoRepository categoriaAlimentoRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoriaAlimentoDto registrarCategoria(CategoriaAlimentoDto categoriaDto) {
        CategoriaAlimento categoria = modelMapper.map(categoriaDto, CategoriaAlimento.class);
        return modelMapper.map(categoriaAlimentoRepository.save(categoria), CategoriaAlimentoDto.class);
    }

    @Override
    public CategoriaAlimentoDto actualizarCategoria(CategoriaAlimentoDto categoriaDto) {
        CategoriaAlimento categoria = categoriaAlimentoRepository.findById(categoriaDto.getId_categoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        categoria.setNombre(categoriaDto.getNombre());
        categoria.setDescripcion(categoriaDto.getDescripcion());

        return modelMapper.map(categoriaAlimentoRepository.save(categoria), CategoriaAlimentoDto.class);
    }

    @Override
    public void eliminarCategoria(Long idCategoria) {
        categoriaAlimentoRepository.deleteById(idCategoria);
    }

    @Override
    public List<CategoriaAlimentoDto> listarCategorias() {
        return categoriaAlimentoRepository.findAll().stream()
                .map(c -> modelMapper.map(c, CategoriaAlimentoDto.class))
                .collect(Collectors.toList());
    }
}
