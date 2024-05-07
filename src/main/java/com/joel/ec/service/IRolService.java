package com.joel.ec.service;

import com.joel.ec.model.entity.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> listAll();
    Rol findById(Integer Id);
}
