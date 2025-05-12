package com.upc.food_save.dtos;

import java.time.LocalDate;

public class InventarioAlimentoDto {
    private Long id_inventario;
    private int cantidad_inicial;
    private int cantidad_consumida;
    private int cantidad_vencida;
    private LocalDate fecha_registro;
    private LocalDate fecha_actualizacion;
    private Long id_usuario;
    private Long id_alimento;

    public InventarioAlimentoDto(Long id_inventario, int cantidad_inicial, int cantidad_consumida, int cantidad_vencida, LocalDate fecha_registro, LocalDate fecha_actualizacion, Long id_usuario, Long id_alimento) {
        this.id_inventario = id_inventario;
        this.cantidad_inicial = cantidad_inicial;
        this.cantidad_consumida = cantidad_consumida;
        this.cantidad_vencida = cantidad_vencida;
        this.fecha_registro = fecha_registro;
        this.fecha_actualizacion = fecha_actualizacion;
        this.id_usuario = id_usuario;
        this.id_alimento = id_alimento;
    }
    public InventarioAlimentoDto() {}

    public Long getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(Long id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getCantidad_inicial() {
        return cantidad_inicial;
    }

    public void setCantidad_inicial(int cantidad_inicial) {
        this.cantidad_inicial = cantidad_inicial;
    }

    public int getCantidad_consumida() {
        return cantidad_consumida;
    }

    public void setCantidad_consumida(int cantidad_consumida) {
        this.cantidad_consumida = cantidad_consumida;
    }

    public int getCantidad_vencida() {
        return cantidad_vencida;
    }

    public void setCantidad_vencida(int cantidad_vencida) {
        this.cantidad_vencida = cantidad_vencida;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDate getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDate fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
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
