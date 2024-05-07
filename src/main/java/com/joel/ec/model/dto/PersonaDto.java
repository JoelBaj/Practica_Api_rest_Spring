package com.joel.ec.model.dto;

import com.joel.ec.model.entity.Usuario;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Builder
public class PersonaDto  implements Serializable {

    private Integer idPersona;
    private String Nombre;
    private String Apellido;
    private String Identificacion;
    private Date FechaNacimiento;
    private List<Usuario> usuario;

}
