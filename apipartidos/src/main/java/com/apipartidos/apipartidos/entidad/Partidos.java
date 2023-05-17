package com.apipartidos.apipartidos.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "partidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index(columnList = "idPartido", name = "index_idpartido", unique = true)
})
public class Partidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String idPartido;

    private Date fecha;


    private String golesLocal;
    private String golesVisitante;

    @CreatedDate
    private Date creado;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_equipolocal")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "id_equipoVisitante")
    private Equipo equipoVisitante;


}
