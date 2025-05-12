package com.upc.food_save.dtos;

public class ReporteConsumoDto {
    private int totalConsumidos;
    private int totalVencidos;
    private double porcentajeEficiencia;
    private double ahorroEstimado;

    public ReporteConsumoDto(int totalConsumidos, int totalVencidos, double porcentajeEficiencia, double ahorroEstimado) {
        this.totalConsumidos = totalConsumidos;
        this.totalVencidos = totalVencidos;
        this.porcentajeEficiencia = porcentajeEficiencia;
        this.ahorroEstimado = ahorroEstimado;
    }
    public ReporteConsumoDto() {}

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
