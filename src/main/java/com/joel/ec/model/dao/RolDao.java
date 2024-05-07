package com.joel.ec.model.dao;

import com.joel.ec.model.entity.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolDao extends CrudRepository<Rol, Integer> {

}
