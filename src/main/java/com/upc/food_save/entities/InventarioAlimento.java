package com.upc.food_save.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class InventarioAlimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inventario;
    private int cantidad_inicial;
    private int cantidad_consumida;
    private int cantidad_vencida;
    private LocalDate fecha_registro;
    private LocalDate fecha_actualizacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_alimento")
    private Alimento alimento;

    public InventarioAlimento(Long id_inventario, int cantidad_inicial, int cantidad_consumida, int cantidad_vencida, LocalDate fecha_registro, LocalDate fecha_actualizacion, Usuario usuario, Alimento alimento) {
        this.id_inventario = id_inventario;
        this.cantidad_inicial = cantidad_inicial;
        this.cantidad_consumida = cantidad_consumida;
        this.cantidad_vencida = cantidad_vencida;
        this.fecha_registro = fecha_registro;
        this.fecha_actualizacion = fecha_actualizacion;
        this.usuario = usuario;
        this.alimento = alimento;
    }
    public InventarioAlimento() {}

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }
}
