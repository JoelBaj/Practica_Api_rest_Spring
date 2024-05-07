package com.joel.ec.service.impl;


import com.joel.ec.model.dao.UsuarioDao;
import com.joel.ec.model.entity.Persona;
import com.joel.ec.model.entity.Usuario;
import com.joel.ec.service.IUsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listAll() {
        return (List) usuarioDao.findAll();
    }

    @Transactional()
    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }
}
