package com.joel.ec.model.repository;

import com.joel.ec.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

}
