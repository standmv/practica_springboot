package com.demoyageek.practica_springboot.Entities;
import java.util.List;

public class AlquilerParametro {

    private String cliente;
    private String fechaEntrega;
    private List<String> equipos;

    public AlquilerParametro() {
    }

    public AlquilerParametro(String cliente, String fechaEntrega, List<String> equipos) {
        this.cliente = cliente;
        this.fechaEntrega = fechaEntrega;
        this.equipos = equipos;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<String> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<String> equipos) {
        this.equipos = equipos;
    }
}
