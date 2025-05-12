package com.upc.food_save.dtos;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;


public class HistorialAlimentoDto implements Serializable {
    Long id_historial;
    String accion;
    String comentario;
    LocalDateTime fecha;
    Long id_usuario;
    Long id_alimento;

    public HistorialAlimentoDto(Long id_historial, String accion, String comentario, LocalDateTime fecha, Long id_usuario, Long id_alimento) {
        this.id_historial = id_historial;
        this.accion = accion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.id_alimento = id_alimento;
    }

    public HistorialAlimentoDto() {}

    public Long getId_historial() {
        return id_historial;
    }

    public void setId_historial(Long id_historial) {
        this.id_historial = id_historial;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Long getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(Long id_alimento) {
        this.id_alimento = id_alimento;
    }
}