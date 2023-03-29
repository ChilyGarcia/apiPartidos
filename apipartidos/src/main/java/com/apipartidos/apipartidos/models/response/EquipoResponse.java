package com.apipartidos.apipartidos.models.response;

public class EquipoResponse {

    private long id;
    private String nombre;

    public EquipoResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
