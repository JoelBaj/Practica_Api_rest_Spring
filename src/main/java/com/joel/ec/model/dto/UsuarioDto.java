package com.joel.ec.model.dto;

import com.joel.ec.model.entity.Persona;
import com.joel.ec.model.entity.Rol_usuario;
import com.joel.ec.model.entity.Session;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Data
@ToString
@Builder
public class UsuarioDto implements Serializable {

    private Integer IdUsuario;
    private String UserName;
    private String Password;
    private String Mail;
    private String SessionActive;
    private String Status;
    private Persona persona;
    private List<Session> sessiones;
    private List<Rol_usuario> rol_usuarios;

}
