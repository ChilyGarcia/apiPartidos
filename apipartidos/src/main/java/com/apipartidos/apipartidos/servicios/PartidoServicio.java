package com.apipartidos.apipartidos.servicios;

import com.apipartidos.apipartidos.dto.PartidoDto;

import java.util.List;

public interface PartidoServicio {

    public PartidoDto crearPartido(PartidoDto partidoDto);

    public List<PartidoDto> partidosCreados();

    public PartidoDto detallePartido(String id);

    public PartidoDto actualizarPartido(String idPartido, PartidoDto partidoDtoActualizar);

    public void eliminarPartido(String idPartido, long idUsuario);
}
