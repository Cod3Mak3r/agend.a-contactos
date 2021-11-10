package com.contactos.agenda.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contactos.agenda.app.entities.Contacto;

@Repository
public interface IPersonaDao extends CrudRepository<Contacto, Long> {

}
