package com.apipartidos.apipartidos.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class UsuarioDto {

    private long id;

    @NotEmpty
    private String idUsuario;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String passwordEncriptada;

    @NotEmpty
    private String password;
    public UsuarioDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
