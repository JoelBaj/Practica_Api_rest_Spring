package com.joel.ec.service;

import com.joel.ec.model.entity.Rol_opciones;

import java.util.List;

public interface IRolOpcionesService {
    List<Rol_opciones> listAll();
    Rol_opciones findById(Integer Id);
}
