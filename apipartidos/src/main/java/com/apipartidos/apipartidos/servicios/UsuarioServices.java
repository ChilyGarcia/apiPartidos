package com.apipartidos.apipartidos.servicios;

import com.apipartidos.apipartidos.dto.UsuarioDto;

public interface UsuarioServices {

    public UsuarioDto crearUsuario(UsuarioDto usuarioDto);

    public UsuarioDto buscarUsuario(String username);






}
