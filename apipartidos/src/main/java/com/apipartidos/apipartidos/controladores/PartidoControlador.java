package com.apipartidos.apipartidos.controladores;

import com.apipartidos.apipartidos.dto.EquipoDto;
import com.apipartidos.apipartidos.dto.PartidoDto;
import com.apipartidos.apipartidos.dto.UsuarioDto;
import com.apipartidos.apipartidos.models.request.PartidoActualizarRequest;
import com.apipartidos.apipartidos.models.request.PartidoRequest;
import com.apipartidos.apipartidos.models.response.EquipoResponse;
import com.apipartidos.apipartidos.models.response.MensajeResponse;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/partido")
public class PartidoControlador {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PartidoServicio partidoServicio;

    @Autowired
    private UsuarioServices usuarioServices;

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

    @GetMapping(path = "leerPartidos")
    public List<PartidoResponse> listaPartidos()
    {
         List<PartidoDto> partidoDtoList = partidoServicio.partidosCreados();

         List<PartidoResponse> partidoResponseList = new ArrayList<>();

         for(PartidoDto partidoDto : partidoDtoList){
              PartidoResponse partidoResponse = modelMapper.map(partidoDto, PartidoResponse.class);
              partidoResponseList.add(partidoResponse);
         }

         return partidoResponseList;
    }

    @GetMapping(path = "{id}")
    public PartidoResponse detallePartido(@PathVariable("id")String id)
    {
        PartidoDto partidoDto = partidoServicio.detallePartido(id);

        PartidoResponse partidoResponse = modelMapper.map(partidoDto, PartidoResponse.class);

        return partidoResponse;
    }

    @PutMapping(path = "{id}/{username}")
    public PartidoResponse actualizarPartidos(@PathVariable("id") String id,
                                              @PathVariable("username")String username,
                                              @RequestBody PartidoActualizarRequest partidoActualizarRequest)
    {

        PartidoDto partidoActualizarDto = modelMapper.map(partidoActualizarRequest, PartidoDto.class);

        partidoActualizarDto.setUsername(username);

        PartidoDto partidoDto = partidoServicio.actualizarPartido(id, partidoActualizarDto);

        PartidoResponse partidoResponse = modelMapper.map(partidoDto, PartidoResponse.class);

        return partidoResponse;

    }

    @DeleteMapping(path = "{id}/{username}")
    public MensajeResponse eliminarPartido(@PathVariable("id")String id,
                                           @PathVariable("username")String username)
    {

        UsuarioDto usuarioDto = usuarioServices.buscarUsuario(username);

        MensajeResponse mensajeResponse = new MensajeResponse();
        mensajeResponse.setNombre("Eliminar");

        partidoServicio.eliminarPartido(id, usuarioDto.getId());

        mensajeResponse.setResultado("El partido se elimino con exito");

        return mensajeResponse;




    }




}
