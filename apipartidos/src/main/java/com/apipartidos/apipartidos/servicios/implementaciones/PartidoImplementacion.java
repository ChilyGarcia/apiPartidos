package com.apipartidos.apipartidos.servicios.implementaciones;

import com.apipartidos.apipartidos.dto.PartidoDto;
import com.apipartidos.apipartidos.entidad.Equipo;
import com.apipartidos.apipartidos.entidad.Partidos;
import com.apipartidos.apipartidos.entidad.Usuario;
import com.apipartidos.apipartidos.repositorio.EquipoRepositorio;
import com.apipartidos.apipartidos.repositorio.PartidoRepositorio;
import com.apipartidos.apipartidos.repositorio.UsuarioRepositorio;
import com.apipartidos.apipartidos.servicios.PartidoServicio;
import com.apipartidos.apipartidos.servicios.UsuarioServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PartidoImplementacion implements PartidoServicio {

    @Autowired
    private PartidoRepositorio partidoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private EquipoRepositorio equipoRepositorio;



    @Override
    public PartidoDto crearPartido(PartidoDto partidoDto)
    {
        Partidos partido = mapearEntidad(partidoDto);
        partidoRepositorio.save(partido);
        PartidoDto partidoDtoResponse = mapearDto(partido);

        return partidoDtoResponse;
    }

    @Override
    public List<PartidoDto> partidosCreados() {

        List<Partidos> listaPartidos = partidoRepositorio.partidosCreados();

        List<PartidoDto> partidoDtoList = new ArrayList<>();

        for (Partidos partidos : listaPartidos)
        {
            PartidoDto partidoDto = modelMapper.map(partidos, PartidoDto.class);
            partidoDtoList.add(partidoDto);

        }

        return partidoDtoList;
    }

    @Override
    public PartidoDto detallePartido(String id) {

        Partidos partidos = partidoRepositorio.findByIdPartido(id);

        PartidoDto partidoDto = modelMapper.map(partidos, PartidoDto.class);

        return partidoDto;
    }

    @Override
    public PartidoDto actualizarPartido(String idPartido, PartidoDto partidoDtoActualizar) {

        Partidos partidos = partidoRepositorio.findByIdPartido(idPartido);

        Usuario usuario = usuarioRepositorio.findByUsername(partidoDtoActualizar.getUsername());


        if(partidos.getUsuario().getId() != usuario.getId())
        {
            throw new RuntimeException("No se puede realizar esta accion");
        }

        partidos.setGolesLocal(partidoDtoActualizar.getGolesLocal());
        partidos.setGolesVisitante(partidoDtoActualizar.getGolesVisitante());

        Partidos partidoActualizado = partidoRepositorio.save(partidos);

        PartidoDto partidoDtoActualizado = modelMapper.map(partidoActualizado, PartidoDto.class);

        return partidoDtoActualizado;



    }

    @Override
    public void eliminarPartido(String idPartido, long idUsuario) {

        Partidos partido = partidoRepositorio.findByIdPartido(idPartido);

        if(partido.getUsuario().getId() != idUsuario)
        {
            throw new RuntimeException("No se puede eliminar este partido");
        }

        partidoRepositorio.delete(partido);
    }


    //Mapear entidad a DTO
    public Partidos mapearEntidad(PartidoDto partidoDto)
    {
        String idLocal = partidoDto.getEquipoLocal();
        String idVisitante = partidoDto.getEquipoVisitante();
        long idLocalLong = Long.parseLong(idLocal);
        long idVisitanteLong = Long.parseLong(idVisitante);

        Usuario usuario= usuarioRepositorio.findByUsername(partidoDto.getUsername());

        Equipo equipoLocal = equipoRepositorio.findById(idLocalLong);
        Equipo equipoVisitante = equipoRepositorio.findById(idVisitanteLong);

        Partidos partido = modelMapper.map(partidoDto, Partidos.class);
        partido.setIdPartido(UUID.randomUUID().toString());
        partido.setGolesLocal("0");
        partido.setGolesVisitante("0");
        partido.setUsuario(usuario);
        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);


        return partido;
    }

    //Mapear de DTO a entidad

    public PartidoDto mapearDto(Partidos partidos)
    {
        PartidoDto partidoDto = modelMapper.map(partidos, PartidoDto.class);
        return partidoDto;
    }
}
