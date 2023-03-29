package com.apipartidos.apipartidos.dto;

import com.apipartidos.apipartidos.entidad.Equipo;
import com.apipartidos.apipartidos.entidad.Usuario;

import java.util.Date;

public class PartidoDto {

    private long id;
    private String idPartido;
    private String username;
    private String equipoLocal;
    private String equipoVisitante;
    private Date fecha;
    private String golesLocal;
    private String golesVisitante;
    private UsuarioDto usuarioDto;
    private EquipoDto equipoDtoLocal;
    private EquipoDto equipoDtoVisitante;


    public PartidoDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public EquipoDto getEquipoDtoLocal() {
        return equipoDtoLocal;
    }

    public void setEquipoDtoLocal(EquipoDto equipoDtoLocal) {
        this.equipoDtoLocal = equipoDtoLocal;
    }

    public EquipoDto getEquipoDtoVisitante() {
        return equipoDtoVisitante;
    }

    public void setEquipoDtoVisitante(EquipoDto equipoDtoVisitante) {
        this.equipoDtoVisitante = equipoDtoVisitante;
    }
}
