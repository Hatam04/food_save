package com.upc.food_save.services;

import com.upc.food_save.dtos.HistorialAlimentoDto;
import com.upc.food_save.entities.Alimento;
import com.upc.food_save.entities.HistorialAlimento;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.IHistorialAlimentoService;
import com.upc.food_save.repositories.AlimentoRepository;
import com.upc.food_save.repositories.HistorialAlimentoRepository;
import com.upc.food_save.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistorialAlimentoService implements IHistorialAlimentoService {
    @Autowired
    private HistorialAlimentoRepository historialRepo;
    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private AlimentoRepository alimentoRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<HistorialAlimentoDto> listarPorUsuario(Long idUsuario) {
        return historialRepo.findByUsuario_IdOrderByFechaDesc(idUsuario).stream()
                .map(h -> modelMapper.map(h, HistorialAlimentoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void registrarEvento(HistorialAlimentoDto dto) {
        Usuario usuario = usuarioRepo.findById(dto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Alimento alimento = alimentoRepo.findById(dto.getId_alimento())
                .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

        HistorialAlimento historial = new HistorialAlimento();
        historial.setAccion(dto.getAccion());
        historial.setComentario(dto.getComentario());
        historial.setFecha(LocalDateTime.now());
        historial.setUsuario(usuario);
        historial.setAlimento(alimento);

        historialRepo.save(historial);
    }
}
