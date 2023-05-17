package com.apipartidos.apipartidos.repositorio;

import com.apipartidos.apipartidos.entidad.Partidos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PartidoRepositorio extends PagingAndSortingRepository<Partidos, Long> {

    List<Partidos> getByUsuarioIdOrderByCreadoDesc(long usuarioId);

    @Query(nativeQuery = true, value = "SELECT * FROM partido ORDER BY creado DESC LIMIT 10")
    List<Partidos> partidosCreados();

    Partidos findByIdPartido(String id);
    
}
