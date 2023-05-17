package com.apipartidos.apipartidos.servicios;

import com.apipartidos.apipartidos.dto.PartidoDto;
import com.apipartidos.apipartidos.dto.UsuarioDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsuarioServices extends UserDetails {

    public UsuarioDto crearUsuario(UsuarioDto usuarioDto);

    public UsuarioDto buscarUsuario(String username);

    public List<PartidoDto> leerMisPartidos(String username);








}
