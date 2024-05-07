package com.joel.ec.controller;

import com.joel.ec.model.dto.RolOpcionesDto;
import com.joel.ec.model.entity.Rol_opciones;
import com.joel.ec.model.payload.MensajeResponse;
import com.joel.ec.service.IRolOpcionesService;
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
public class RolOpcionesController {
    @Autowired
    private IRolOpcionesService rolOpcionesService;

    @GetMapping("rolopciones")
    public ResponseEntity<?> showAll(){
        List<Rol_opciones> geList = rolOpcionesService.listAll();

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
    @GetMapping("rolopciones/{id}")
    public ResponseEntity<?>  showById(@PathVariable Integer id){
        Rol_opciones rol_opciones = rolOpcionesService.findById(id);

        if (rol_opciones == null){
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
                        .object( RolOpcionesDto.builder()
                                .IdOpcion(rol_opciones.getIdOpcion())
                                .NombreOpcion(rol_opciones.getNombreOpcion())
                                .rol_operaciones(rol_opciones.getRol_operaciones())
                                .build())
                        .build()
                , HttpStatus.OK);
    }
}

