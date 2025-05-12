package com.upc.food_save.interfaces;

import com.upc.food_save.dtos.NotificacionDto;

import java.util.List;

public interface INotificacionService {
    void enviarNotificacion(NotificacionDto dto);
    List<NotificacionDto> listarPorUsuario(Long idUsuario);
    void marcarComoLeida(Long idNotificacion);
}
