package com.joel.ec.model.dto;

import com.joel.ec.model.entity.Rol_operaciones;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
public class RolOpcionesDto {

    private Integer IdOpcion;
    private String NombreOpcion;
    private List<Rol_operaciones> rol_operaciones;

}
