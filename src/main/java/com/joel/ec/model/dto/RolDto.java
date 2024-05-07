package com.joel.ec.model.dto;

import com.joel.ec.model.entity.Rol_operaciones;
import com.joel.ec.model.entity.Rol_usuario;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class RolDto implements Serializable {

    private Integer IdRol;
    private String RolName;
    private List<Rol_usuario> rol_usuarios;
    private List<Rol_operaciones> rol_operaciones;
}

