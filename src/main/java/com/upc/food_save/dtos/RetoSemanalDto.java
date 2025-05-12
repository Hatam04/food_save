package com.upc.food_save.dtos;

import java.time.LocalDate;

public class RetoSemanalDto {
    private Long id_reto_semanal;
    private String titulo;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String nivel_dificultad;

    public RetoSemanalDto(Long id_reto_semanal, String titulo, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin, String nivel_dificultad) {
        this.id_reto_semanal = id_reto_semanal;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.nivel_dificultad = nivel_dificultad;
    }

    public RetoSemanalDto() {}

    public Long getId_reto_semanal() {
        return id_reto_semanal;
    }

    public void setId_reto_semanal(Long id_reto_semanal) {
        this.id_reto_semanal = id_reto_semanal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getNivel_dificultad() {
        return nivel_dificultad;
    }

    public void setNivel_dificultad(String nivel_dificultad) {
        this.nivel_dificultad = nivel_dificultad;
    }
}
