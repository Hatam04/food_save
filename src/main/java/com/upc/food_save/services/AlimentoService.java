package com.upc.food_save.services;

import com.upc.food_save.dtos.AlimentoDto;
import com.upc.food_save.entities.Alimento;
import com.upc.food_save.entities.CategoriaAlimento;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.IAlimentoService;
import com.upc.food_save.repositories.AlimentoRepository;
import com.upc.food_save.repositories.CategoriaAlimentoRepository;
import com.upc.food_save.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlimentoService implements IAlimentoService {
    @Autowired
    private AlimentoRepository alimentoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CategoriaAlimentoRepository categoriaAlimentoRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AlimentoDto registrarAlimento(AlimentoDto alimentoDto) {
        Alimento alimento = modelMapper.map(alimentoDto, Alimento.class);

        Usuario usuario = usuarioRepository.findById(alimentoDto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        CategoriaAlimento categoria = categoriaAlimentoRepository.findById(alimentoDto.getId_categoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        alimento.setUsuario(usuario);
        alimento.setCategoria(categoria);
        alimento.setFecha_registro(LocalDate.now());
        alimento.setEstado("Disponible"); // Valor por defecto al registrar

        return modelMapper.map(alimentoRepository.save(alimento), AlimentoDto.class);
    }

    @Override
    public AlimentoDto actualizarCategoria(Long idAlimento, Long idCategoria) {
        Alimento alimento = alimentoRepository.findById(idAlimento)
                .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));
        CategoriaAlimento nuevaCategoria = categoriaAlimentoRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        alimento.setCategoria(nuevaCategoria);

        return modelMapper.map(alimentoRepository.save(alimento), AlimentoDto.class);
    }

    @Override
    public List<AlimentoDto> listarAlimentosPorUsuario(Long id_usuario) {
        return alimentoRepository.findByUsuario_Id(id_usuario).stream()
                .map(a -> modelMapper.map(a, AlimentoDto.class))
                .collect(Collectors.toList());
    }
}
