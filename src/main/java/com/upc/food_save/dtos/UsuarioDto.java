package com.upc.food_save.dtos;

import java.time.LocalDate;

public class UsuarioDto {
    private Long id_usuario;
    private String nombre_completo;
    private String correo;
    private String contrasenia;
    private LocalDate fecha_registro;
    private boolean preferencia;

    public UsuarioDto(Long id_usuario, String nombre_completo, String correo, String contrasenia, LocalDate fecha_registro, boolean preferencia) {
        this.id_usuario = id_usuario;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.fecha_registro = fecha_registro;
        this.preferencia = preferencia;
    }
    public UsuarioDto() {}

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isPreferencia() {
        return preferencia;
    }

    public void setPreferencia(boolean preferencia) {
        this.preferencia = preferencia;
    }
}
