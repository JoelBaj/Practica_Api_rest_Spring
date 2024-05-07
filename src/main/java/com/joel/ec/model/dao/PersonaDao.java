package com.joel.ec.model.dao;

import com.joel.ec.model.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends CrudRepository<Persona, Integer> {
}
