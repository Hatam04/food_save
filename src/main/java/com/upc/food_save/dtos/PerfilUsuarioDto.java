package com.upc.food_save.dtos;

public class PerfilUsuarioDto {
    private Long id_perfil;
    private String foto_perfil;
    private String objetivo;
    private String nivel_compromiso;
    private Long id_usuario;

    public PerfilUsuarioDto(Long id_perfil, String foto_perfil, String objetivo, String nivel_compromiso, Long id_usuario) {
        this.id_perfil = id_perfil;
        this.foto_perfil = foto_perfil;
        this.objetivo = objetivo;
        this.nivel_compromiso = nivel_compromiso;
        this.id_usuario = id_usuario;
    }

    public PerfilUsuarioDto() {}

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

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
