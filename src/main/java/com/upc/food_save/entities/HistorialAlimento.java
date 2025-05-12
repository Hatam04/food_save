package com.upc.food_save.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class HistorialAlimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historial;

    private String accion; // ejemplo: "Agregado", "Consumido", "Eliminado"
    private String comentario;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_alimento")
    private Alimento alimento;

    public HistorialAlimento(Long id_historial, String accion, String comentario, LocalDateTime fecha, Usuario usuario, Alimento alimento) {
        this.id_historial = id_historial;
        this.accion = accion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.usuario = usuario;
        this.alimento = alimento;
    }
    public HistorialAlimento() {}

    public Long getId_historial() {
        return id_historial;
    }

    public void setId_historial(Long id_historial) {
        this.id_historial = id_historial;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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
