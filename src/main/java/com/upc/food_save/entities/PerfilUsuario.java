package com.upc.food_save.entities;

import jakarta.persistence.*;

@Entity
public class PerfilUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_perfil;
    private String foto_perfil;
    @Column(length = 200)
    private String objetivo;
    private String nivel_compromiso;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public PerfilUsuario(Long id_perfil, String foto_perfil, String objetivo, String nivel_compromiso, Usuario usuario) {
        this.id_perfil = id_perfil;
        this.foto_perfil = foto_perfil;
        this.objetivo = objetivo;
        this.nivel_compromiso = nivel_compromiso;
        this.usuario = usuario;
    }
    public PerfilUsuario() {}

    public Long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getNivel_compromiso() {
        return nivel_compromiso;
    }

    public void setNivel_compromiso(String nivel_compromiso) {
        this.nivel_compromiso = nivel_compromiso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
