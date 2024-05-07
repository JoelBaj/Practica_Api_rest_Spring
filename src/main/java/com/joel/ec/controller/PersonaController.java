package com.joel.ec.controller;

import com.joel.ec.model.dto.PersonaDto;
import com.joel.ec.model.entity.Persona;
import com.joel.ec.model.payload.MensajeResponse;
import com.joel.ec.service.IPersonaService;
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

public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("personas")
    public ResponseEntity<?> showAll(){
        List<Persona> geList = personaService.listAll();

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
    @GetMapping("personas/{id}")
    public ResponseEntity<?>  showById(@PathVariable Integer id){
        Persona persona = personaService.findById(id);

        if (persona == null){
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
                        .object(PersonaDto.builder()
                                .idPersona(persona.getIdPersona())
                                .Nombre(persona.getNombre())
                                .Apellido(persona.getApellido())
                                .Identificacion(persona.getIdentificacion())
                                .FechaNacimiento(persona.getFechaNacimiento())
                                .build())
                        .build()
                , HttpStatus.OK);
    }
}