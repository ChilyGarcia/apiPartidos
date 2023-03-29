package com.apipartidos.apipartidos.entidad;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoLocal")
    private List<Partidos> listaPartidosLocales = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoVisitante")
    private List<Partidos> listaPartidosVisitante = new ArrayList<>();

    public Equipo() {
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

    public List<Partidos> getListaPartidosLocales() {
        return listaPartidosLocales;
    }

    public void setListaPartidosLocales(List<Partidos> listaPartidosLocales) {
        this.listaPartidosLocales = listaPartidosLocales;
    }

    public List<Partidos> getListaPartidosVisitante() {
        return listaPartidosVisitante;
    }

    public void setListaPartidosVisitante(List<Partidos> listaPartidosVisitante) {
        this.listaPartidosVisitante = listaPartidosVisitante;
    }
}
