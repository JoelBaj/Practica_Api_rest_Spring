package com.joel.ec.controller;

import com.joel.ec.model.dto.UsuarioDto;
import com.joel.ec.model.entity.Usuario;
import com.joel.ec.model.payload.MensajeResponse;
import com.joel.ec.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("usuarios")
    public ResponseEntity<?> showAll(){
        List<Usuario> geList = usuarioService.listAll();

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
    @GetMapping("usuarios/{id}")
    public ResponseEntity<?>  showById(@PathVariable Integer id){
        Usuario usuario = usuarioService.findById(id);

        if (usuario == null){
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
                        .object( UsuarioDto.builder()
                                .IdUsuario(usuario.getIdUsuario())
                                .UserName(usuario.getUserName())
                                .Password(usuario.getPassword())
                                .SessionActive(usuario.getSessionActive())
                                .persona(usuario.getPersona())
                                .build())
                        .build()
                , HttpStatus.OK);
    }
}
