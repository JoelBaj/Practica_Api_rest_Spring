package com.joel.ec.service;

import com.joel.ec.model.entity.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> listAll();
    Persona findById(Integer Id);


}
