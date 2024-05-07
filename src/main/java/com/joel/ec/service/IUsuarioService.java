package com.joel.ec.service;

import com.joel.ec.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listAll();
    Usuario findById(Integer Id);

}
