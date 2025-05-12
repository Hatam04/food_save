package com.upc.food_save.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_completo;
    @Column(unique=true)
    private String correo;
    @Size(min=8)
    private String contrasenia;
    private LocalDate fecha_registro;
    private boolean preferencia;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Rol> roles = new HashSet<>();

    public Usuario(Long id_usuario, String nombre_completo, String correo, String contrasenia, LocalDate fecha_registro, boolean preferencia, Set<Rol> roles) {
        this.id = id_usuario;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.fecha_registro = fecha_registro;
        this.preferencia = preferencia;
        this.roles = roles;
    }
    public Usuario() {}

    public Long getId_usuario() {
        return id;
    }

    public void setId_usuario(Long id_usuario) {
        this.id = id_usuario;
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

    public @Size(min = 8) String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(@Size(min = 8) String contrasenia) {
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
