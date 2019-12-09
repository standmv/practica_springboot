package com.demoyageek.practica_springboot.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String usuario;

    private String password;

    private boolean activo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rol> rolSet;

    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String password, boolean activo, Set<Rol> rolSet) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
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

    public Set<Rol> getRolSet() {
        return rolSet;
    }

    public void setRolSet(Set<Rol> rolSet) {
        this.rolSet = rolSet;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
