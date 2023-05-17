package com.apipartidos.apipartidos.servicios.implementaciones;

import com.apipartidos.apipartidos.dto.PartidoDto;
import com.apipartidos.apipartidos.dto.UsuarioDto;
import com.apipartidos.apipartidos.entidad.Partidos;
import com.apipartidos.apipartidos.entidad.Usuario;
import com.apipartidos.apipartidos.repositorio.PartidoRepositorio;
import com.apipartidos.apipartidos.repositorio.UsuarioRepositorio;
import com.apipartidos.apipartidos.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioImplementacion implements UsuarioServices {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PartidoRepositorio partidoRepositorio;

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = mapearEntidad(usuarioDto);

        if(usuarioRepositorio.findByEmail(usuario.getEmail()) != null)
        {
            throw new RuntimeException("El correo ya está en uso");
        }
        else if(usuarioRepositorio.findByUsername(usuario.getUsername()) != null)
        {
            throw new RuntimeException("El usuario ya está en uso");
        }

        usuarioRepositorio.save(usuario);
        UsuarioDto response = mapearDto(usuario);

        return response;
    }

    @Override
    public UsuarioDto buscarUsuario(String username) {
        Usuario usuario = usuarioRepositorio.findByUsername(username);
        UsuarioDto usuarioDto = mapearDto(usuario);

        return usuarioDto;

    }

    @Override
    public List<PartidoDto> leerMisPartidos(String username) {

        Usuario usuario = usuarioRepositorio.findByUsername(username);

        List<Partidos> partidosList = partidoRepositorio.getByUsuarioIdOrderByCreadoDesc(usuario.getId());

        List<PartidoDto> partidoDtoList = new ArrayList<PartidoDto>();

        for(Partidos partido : partidosList)
        {
            PartidoDto partidoDto = modelMapper.map(partido, PartidoDto.class);
            partidoDtoList.add(partidoDto);
        }

        return partidoDtoList;
    }


    //Mapear de entidad a DTO
    public Usuario mapearEntidad(UsuarioDto usuarioDto){

        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario.setIdUsuario(UUID.randomUUID().toString());
        usuario.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioDto.getPassword()));
        return usuario;

    }

    //Mapear de DTO a entidad
    public UsuarioDto mapearDto(Usuario usuario)
    {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);

        return usuarioDto;
    }
    
}
