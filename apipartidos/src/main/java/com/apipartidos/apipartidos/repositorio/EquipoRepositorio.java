package com.apipartidos.apipartidos.repositorio;

import com.apipartidos.apipartidos.entidad.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {

    Equipo findById(long id);

}
