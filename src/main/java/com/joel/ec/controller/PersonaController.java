package com.joel.ec.controller;

import com.joel.ec.exception.ResourceNotFoundException;
import com.joel.ec.model.dto.PersonaDto;
import com.joel.ec.model.entity.Persona;
import com.joel.ec.model.payload.MensajeResponse;
import com.joel.ec.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api/v1")

public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("personas")
    public ResponseEntity<?> showAll(){
        List<Persona> geList = personaService.listAll();

        if (geList == null || geList.isEmpty() ){
            throw new ResourceNotFoundException("personas");
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
           throw new ResourceNotFoundException("Persona", "id",id);
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