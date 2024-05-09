package com.joel.ec.service.impl;

import com.joel.ec.model.repository.RolOpcionesDao;
import com.joel.ec.model.entity.Rol_opciones;
import com.joel.ec.service.IRolOpcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolOperacionesImpl implements IRolOpcionesService {

    @Autowired
    private RolOpcionesDao rolOpcionesDao;

    @Override
    public List<Rol_opciones> listAll() {
        return (List) rolOpcionesDao.findAll();
    }

    @Override
    public Rol_opciones findById(Integer Id) {
        return rolOpcionesDao.findById(Id).orElse(null);
    }
}
