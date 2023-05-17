package com.apipartidos.apipartidos.controladores;

import com.apipartidos.apipartidos.dto.PartidoDto;
import com.apipartidos.apipartidos.dto.UsuarioDto;
import com.apipartidos.apipartidos.models.request.UsuarioRequest;
import com.apipartidos.apipartidos.models.response.PartidoResponse;
import com.apipartidos.apipartidos.models.response.UsuarioResponse;
import com.apipartidos.apipartidos.servicios.UsuarioServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UsuarioControlador {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioServices usuarioServices;

    /*
    @PostMapping("/guardar-usuario")
    public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody UsuarioDto usuarioDto)
    {
        return new ResponseEntity<>(usuarioServices.crearUsuario(usuarioDto), HttpStatus.CREATED);
    }

    */


    @PostMapping("/guardar-usuario")
    public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody UsuarioRequest usuarioRequest)
    {
        //Se pasa el request a DTO
        UsuarioDto usuarioDtoMap = modelMapper.map(usuarioRequest, UsuarioDto.class);
        UsuarioDto usuarioDto = usuarioServices.crearUsuario(usuarioDtoMap);

        UsuarioResponse usuarioResponse = modelMapper.map(usuarioDto, UsuarioResponse.class);

        return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);

    }

    @GetMapping("/buscar-usuario/{username}")
    public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable(value = "username") String username)
    {
        UsuarioDto usuarioDto = usuarioServices.buscarUsuario(username);
        UsuarioResponse response = modelMapper.map(usuarioDto, UsuarioResponse.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(path = "mispartidos/{username}")
    public List<PartidoResponse> leerPartidos(@PathVariable(value = "username")String username)
    {

        List<PartidoDto> partidoDtoList = usuarioServices.leerMisPartidos(username);

        List<PartidoResponse> partidoResponseList = new ArrayList<PartidoResponse>();

        for(PartidoDto partidoDto : partidoDtoList)
        {

            PartidoResponse partidoResponse = modelMapper.map(partidoDto, PartidoResponse.class);

            if(partidoResponse.getFecha().compareTo(new Date(System.currentTimeMillis())) <0)
            {
                partidoResponse.setJugado(true);
            }


        }

        return partidoResponseList;

    }

}
