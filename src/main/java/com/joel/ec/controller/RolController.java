package com.joel.ec.controller;

import com.joel.ec.model.dto.RolDto;
import com.joel.ec.model.dto.UsuarioDto;
import com.joel.ec.model.entity.Rol;
import com.joel.ec.model.entity.Usuario;
import com.joel.ec.model.payload.MensajeResponse;
import com.joel.ec.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping("roles")
    public ResponseEntity<?> showAll(){
        List<Rol> geList = rolService.listAll();

        if (geList == null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registro")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(geList)
                        .build()
                , HttpStatus.OK);
    }
    @GetMapping("roles/{id}")
    public ResponseEntity<?>  showById(@PathVariable Integer id){
        Rol rol = rolService.findById(id);

        if (rol == null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro que intenta buscar no exite")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object( RolDto.builder()
                                .IdRol(rol.getIdRol())
                                .RolName(rol.getRolName())
                                .rol_usuarios(rol.getRol_usuarios())
                                .rol_operaciones(rol.getRol_operaciones())
                                .build())
                        .build()
                , HttpStatus.OK);
    }
}
