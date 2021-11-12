package com.contactos.agenda.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contactos.agenda.app.dao.IPersonaDao;
import com.contactos.agenda.app.entities.Contacto;

@Service
public class ContactoServiceImpl implements IContactoService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contacto> listarContactos() {
		return (List<Contacto>) personaDao.findAll();
	}

	@Override
	@Transactional
	public Contacto guardarContacto(Contacto contacto) {
		return personaDao.save(contacto);
	}

	@Override
	@Transactional
	public void eliminarContacto(Long id) {
		personaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Contacto buscarContacto(Long id) {
		return personaDao.findById(id).orElse(null);
	}

}
