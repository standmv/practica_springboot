package com.demoyageek.practica_springboot.Entities;

public class ReporteAlquiler {

    private int cliente;

    private int cantidad;

    public ReporteAlquiler() {
    }

    public ReporteAlquiler(int cliente, int cantidad) {
        this.cliente = cliente;
        this.cantidad = cantidad;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
