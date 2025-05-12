package com.upc.food_save.dtos;

public class ReporteConsumidoAdminDto {
    private Long idUsuario;
    private String nombreCompleto;
    private int totalConsumidos;
    private int totalVencidos;
    private double porcentajeEficiencia;
    private double ahorroEstimado;

    public ReporteConsumidoAdminDto(Long idUsuario, String nombreCompleto, int totalConsumidos, int totalVencidos, double porcentajeEficiencia, double ahorroEstimado) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.totalConsumidos = totalConsumidos;
        this.totalVencidos = totalVencidos;
        this.porcentajeEficiencia = porcentajeEficiencia;
        this.ahorroEstimado = ahorroEstimado;
    }
    public ReporteConsumidoAdminDto() {}

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getTotalConsumidos() {
        return totalConsumidos;
    }

    public void setTotalConsumidos(int totalConsumidos) {
        this.totalConsumidos = totalConsumidos;
    }

    public int getTotalVencidos() {
        return totalVencidos;
    }

    public void setTotalVencidos(int totalVencidos) {
        this.totalVencidos = totalVencidos;
    }

    public double getPorcentajeEficiencia() {
        return porcentajeEficiencia;
    }

    public void setPorcentajeEficiencia(double porcentajeEficiencia) {
        this.porcentajeEficiencia = porcentajeEficiencia;
    }

    public double getAhorroEstimado() {
        return ahorroEstimado;
    }

    public void setAhorroEstimado(double ahorroEstimado) {
        this.ahorroEstimado = ahorroEstimado;
    }
}
