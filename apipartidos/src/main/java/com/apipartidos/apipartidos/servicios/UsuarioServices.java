package com.apipartidos.apipartidos.servicios;

import com.apipartidos.apipartidos.dto.PartidoDto;
import com.apipartidos.apipartidos.dto.UsuarioDto;


import java.util.List;

public interface UsuarioServices {

    public UsuarioDto crearUsuario(UsuarioDto usuarioDto);

    public UsuarioDto buscarUsuario(String username);

    public List<PartidoDto> leerMisPartidos(String username);








}
