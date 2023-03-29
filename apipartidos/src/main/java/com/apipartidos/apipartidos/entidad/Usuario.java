package com.apipartidos.apipartidos.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "usuarios")
@Table(indexes = {
        @Index(columnList = "idUsuario", name = "index_idUsuario", unique = true),
        @Index(columnList = "email", name = "index_email", unique = true),
        @Index(columnList = "username", name = "index_username", unique = true)
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String idUsuario;
    private String nombre;
    private String email;
    private String username;
    private String passwordEncriptada;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
    private Set<Partidos> listaPartidos = new HashSet<>();



    public Usuario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordEncriptada() {
        return passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }

    public Set<Partidos> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(Set<Partidos> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
}
