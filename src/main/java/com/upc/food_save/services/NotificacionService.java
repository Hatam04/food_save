package com.upc.food_save.services;

import com.upc.food_save.dtos.NotificacionDto;
import com.upc.food_save.entities.Notificacion;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.INotificacionService;
import com.upc.food_save.repositories.NotificacionRepository;
import com.upc.food_save.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService implements INotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepo;
    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void enviarNotificacion(NotificacionDto dto) {
        Usuario usuario = usuarioRepo.findById(dto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Notificacion noti = new Notificacion();
        noti.setMensaje(dto.getMensaje());
        noti.setFecha(LocalDateTime.now());
        noti.setLeida(false);
        noti.setUsuario(usuario);

        notificacionRepo.save(noti);
    }

    @Override
    public List<NotificacionDto> listarPorUsuario(Long idUsuario) {
        return notificacionRepo.findByUsuario_IdOrderByFechaDesc(idUsuario).stream()
                .map(n -> modelMapper.map(n, NotificacionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void marcarComoLeida(Long idNotificacion) {
        Notificacion noti = notificacionRepo.findById(idNotificacion)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));

        noti.setLeida(true);
        notificacionRepo.save(noti);
    }
}
