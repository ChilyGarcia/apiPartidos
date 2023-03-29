package com.apipartidos.apipartidos.controladores;

import com.apipartidos.apipartidos.dto.EquipoDto;
import com.apipartidos.apipartidos.dto.PartidoDto;
import com.apipartidos.apipartidos.models.request.PartidoRequest;
import com.apipartidos.apipartidos.models.response.EquipoResponse;
import com.apipartidos.apipartidos.models.response.PartidoResponse;
import com.apipartidos.apipartidos.models.response.UsuarioResponse;
import com.apipartidos.apipartidos.repositorio.EquipoRepositorio;
import com.apipartidos.apipartidos.repositorio.UsuarioRepositorio;
import com.apipartidos.apipartidos.servicios.PartidoServicio;
import com.apipartidos.apipartidos.servicios.UsuarioServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/partido")
public class PartidoControlador {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PartidoServicio partidoServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private EquipoRepositorio equipoRepositorio;


    @PostMapping(value = "/guardar-partido/{username}")
    public ResponseEntity<PartidoResponse> crearPartido(@PathVariable("username")String username, @RequestBody PartidoRequest partidoRequest)
    {
        PartidoDto partidoDto = modelMapper.map(partidoRequest, PartidoDto.class);
        partidoDto.setUsername(username);

        PartidoDto partidoDtoMap = partidoServicio.crearPartido(partidoDto);

        partidoDtoMap.setEquipoLocal(partidoRequest.getEquipoLocal());
        partidoDtoMap.setEquipoVisitante(partidoRequest.getEquipoVisitante());

        long idLocal = Long.parseLong(partidoRequest.getEquipoLocal());
        long idVisitante = Long.parseLong(partidoRequest.getEquipoVisitante());

        UsuarioResponse usuarioResponse = modelMapper.map(usuarioRepositorio.findByUsername(partidoDto.getUsername()), UsuarioResponse.class);
        EquipoResponse equipoResponseLocal = modelMapper.map(equipoRepositorio.findById(idLocal), EquipoResponse.class);
        EquipoResponse equipoResponseVisitante = modelMapper.map(equipoRepositorio.findById(idVisitante), EquipoResponse.class);

        PartidoResponse response = modelMapper.map(partidoDtoMap, PartidoResponse.class);

        response.setUsuario(usuarioResponse);
        response.setEquipoResponseLocal(equipoResponseLocal);
        response.setEquipoResponseVisitante(equipoResponseVisitante);
        response.setJugado(false);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }




}
