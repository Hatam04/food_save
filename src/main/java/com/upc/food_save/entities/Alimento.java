package com.upc.food_save.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alimento;
    private String nombre;
    private String marca;
    private int cantidad;
    private LocalDate fecha_registro;
    private LocalDate fecha_vencimiento;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaAlimento categoria;

    public Alimento(Long id_alimento, String nombre, String marca, int cantidad, LocalDate fecha_registro, LocalDate fecha_vencimiento, String estado, Usuario usuario, CategoriaAlimento categoria) {
        this.id_alimento = id_alimento;
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
        this.fecha_registro = fecha_registro;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
        this.usuario = usuario;
        this.categoria = categoria;
    }
    public Alimento() {}

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CategoriaAlimento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAlimento categoria) {
        this.categoria = categoria;
    }
}
