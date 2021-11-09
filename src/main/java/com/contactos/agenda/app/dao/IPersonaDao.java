package com.contactos.agenda.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.contactos.agenda.app.entities.Contacto;

public interface IPersonaDao extends CrudRepository<Contacto, Long> {

}
