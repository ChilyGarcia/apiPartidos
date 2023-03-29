package com.apipartidos.apipartidos.repositorio;

import com.apipartidos.apipartidos.entidad.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepositorio extends JpaRepository<Partidos, Long> {
    
}
