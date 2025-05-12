package com.upc.food_save.dtos;

import java.time.LocalDate;

public class AlimentoDto {
    private Long id_alimento;
    private String nombre;
    private String marca;
    private int cantidad;
    private LocalDate fecha_registro;
    private LocalDate fecha_vencimiento;
    private String estado;
    private Long id_usuario;
    private Long id_categoria;

    public AlimentoDto(Long id_alimento, String nombre, String marca, int cantidad, LocalDate fecha_registro, LocalDate fecha_vencimiento, String estado, Long id_usuario, Long id_categoria) {
        this.id_alimento = id_alimento;
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
        this.fecha_registro = fecha_registro;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_categoria = id_categoria;
    }
    public AlimentoDto() {}

    public Long getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(Long id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }
}
