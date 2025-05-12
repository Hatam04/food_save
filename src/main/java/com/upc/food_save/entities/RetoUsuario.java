package com.upc.food_save.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RetoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reto_usuario;
    private String estado;
    private LocalDate fecha_participacion;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_reto_semanal")
    private RetoSemanal reto_semanal;

    public RetoUsuario(Long id_reto_usuario, String estado, LocalDate fecha_participacion, Usuario usuario, RetoSemanal reto_semanal) {
        this.id_reto_usuario = id_reto_usuario;
        this.estado = estado;
        this.fecha_participacion = fecha_participacion;
        this.usuario = usuario;
        this.reto_semanal = reto_semanal;
    }
    public RetoUsuario() {}

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RetoSemanal getReto_semanal() {
        return reto_semanal;
    }

    public void setReto_semanal(RetoSemanal reto_semanal) {
        this.reto_semanal = reto_semanal;
    }
}
