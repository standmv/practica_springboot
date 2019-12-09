package com.demoyageek.practica_springboot.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String cedula;
    @Column()
    private long telefono;
    @Column(nullable = true)
    private String correo;

    @Column(columnDefinition = "TEXT")
    private String foto;

    private Boolean activo;

    @OneToMany
    private Set<Rol> rolSet;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, int telefono, String correo, String foto, Boolean activo, Set<Rol> rolSet) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.foto = foto;
        this.activo = activo;
        this.rolSet = rolSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Set<Rol> getRolSet() {
        return rolSet;
    }

    public void setRolSet(Set<Rol> rolSet) {
        this.rolSet = rolSet;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
