package com.apipartidos.apipartidos.models.response;

import com.apipartidos.apipartidos.entidad.Usuario;

import java.util.List;

public class UsuarioResponse {

    private String idUsuario;
    private String nombre;
    private String email;
    private String username;
    public UsuarioResponse() {
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

}
