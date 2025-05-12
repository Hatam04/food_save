package com.upc.food_save.dtos;

import java.time.LocalDate;

public class RetoUsuarioDto {
    private Long id_reto_usuario;
    private String estado;
    private LocalDate fecha_participacion;
    private Long id_usuario;
    private Long id_reto_semanal;


    public RetoUsuarioDto(Long id_reto_usuario, String estado, LocalDate fecha_participacion, Long id_usuario, Long id_reto_semanal) {
        this.id_reto_usuario = id_reto_usuario;
        this.estado = estado;
        this.fecha_participacion = fecha_participacion;
        this.id_usuario = id_usuario;
        this.id_reto_semanal = id_reto_semanal;
    }

    public RetoUsuarioDto() {}

    public Long getId_reto_usuario() {
        return id_reto_usuario;
    }

    public void setId_reto_usuario(Long id_reto_usuario) {
        this.id_reto_usuario = id_reto_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_participacion() {
        return fecha_participacion;
    }

    public void setFecha_participacion(LocalDate fecha_participacion) {
        this.fecha_participacion = fecha_participacion;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_reto_semanal() {
        return id_reto_semanal;
    }

    public void setId_reto_semanal(Long id_reto_semanal) {
        this.id_reto_semanal = id_reto_semanal;
    }
}
