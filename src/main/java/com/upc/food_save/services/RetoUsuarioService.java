package com.upc.food_save.services;

import com.upc.food_save.dtos.RetoUsuarioDto;
import com.upc.food_save.entities.RetoSemanal;
import com.upc.food_save.entities.RetoUsuario;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.IRetoUsuarioService;
import com.upc.food_save.repositories.RetoSemanalRepository;
import com.upc.food_save.repositories.RetoUsuarioRepository;
import com.upc.food_save.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetoUsuarioService implements IRetoUsuarioService {
    @Autowired
    private RetoUsuarioRepository retoUsuarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RetoSemanalRepository retoSemanalRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RetoUsuarioDto inscribirReto(RetoUsuarioDto dto) {
        Usuario usuario = usuarioRepository.findById(dto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        RetoSemanal reto = retoSemanalRepository.findById(dto.getId_reto_semanal())
                .orElseThrow(() -> new RuntimeException("Reto no encontrado"));

        RetoUsuario retoUsuario = new RetoUsuario();
        retoUsuario.setUsuario(usuario);
        retoUsuario.setReto_semanal(reto);
        retoUsuario.setEstado("Inscrito");
        retoUsuario.setFecha_participacion(LocalDate.now());

        return modelMapper.map(retoUsuarioRepository.save(retoUsuario), RetoUsuarioDto.class);
    }

    @Override
    public List<RetoUsuarioDto> listarRetosPorUsuario(Long idUsuario) {
        return retoUsuarioRepository.findByUsuario_Id(idUsuario).stream()
                .map(r -> modelMapper.map(r, RetoUsuarioDto.class))
                .collect(Collectors.toList());
    }
}
