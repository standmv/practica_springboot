package com.demoyageek.practica_springboot.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Factura implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;

    @OneToOne
    private Alquiler alquiler;

    private int total;

    public Factura() {
    }

    public Factura(Date fecha, Alquiler alquiler, int total) {
        this.fecha = fecha;
        this.alquiler = alquiler;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
