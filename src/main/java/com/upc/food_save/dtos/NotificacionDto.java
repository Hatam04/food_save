package com.upc.food_save.dtos;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;


public class NotificacionDto implements Serializable {
    Long id_notificacion;
    String mensaje;
    boolean leida;
    LocalDateTime fecha;
    Long id_usuario;

    public NotificacionDto(Long id_notificacion, String mensaje, boolean leida, LocalDateTime fecha, Long id_usuario) {
        this.id_notificacion = id_notificacion;
        this.mensaje = mensaje;
        this.leida = leida;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
    }
    public NotificacionDto() {}

    public Long getId_notificacion() {
        return id_notificacion;
    }

    public void setId_notificacion(Long id_notificacion) {
        this.id_notificacion = id_notificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }


}