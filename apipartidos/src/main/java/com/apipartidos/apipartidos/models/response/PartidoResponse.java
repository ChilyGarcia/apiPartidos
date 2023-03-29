package com.apipartidos.apipartidos.models.response;

import com.apipartidos.apipartidos.entidad.Usuario;

import java.util.Date;

public class PartidoResponse {

    private String idPartido;
    private Date fecha;
    private String equipoLocal;
    private String equipoVisitante;
    private String golesLocal;
    private String golesVisitante;

    private boolean jugado = false;
    private UsuarioResponse usuario;
    private EquipoResponse equipoResponseLocal;
    private EquipoResponse equipoResponseVisitante;

    public PartidoResponse() {
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }

    public String getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(String golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public UsuarioResponse getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponse usuario) {
        this.usuario = usuario;
    }

    public EquipoResponse getEquipoResponseLocal() {
        return equipoResponseLocal;
    }

    public void setEquipoResponseLocal(EquipoResponse equipoResponseLocal) {
        this.equipoResponseLocal = equipoResponseLocal;
    }

    public EquipoResponse getEquipoResponseVisitante() {
        return equipoResponseVisitante;
    }

    public void setEquipoResponseVisitante(EquipoResponse equipoResponseVisitante) {
        this.equipoResponseVisitante = equipoResponseVisitante;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
}
