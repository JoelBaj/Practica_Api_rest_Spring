package com.joel.ec.service.impl;

import com.joel.ec.model.repository.RolDao;
import com.joel.ec.model.entity.Rol;
import com.joel.ec.service.IRolService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private RolDao rolDao;

    @Override
    public List<Rol> listAll() {
        return (List) rolDao.findAll();
    }

    @Transactional()
    @Override
    public Rol findById(Integer Id) {
        return rolDao.findById(Id).orElse(null);
    }
}
