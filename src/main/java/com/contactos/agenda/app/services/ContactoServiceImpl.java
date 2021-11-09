package com.contactos.agenda.app.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contactos.agenda.app.dao.IPersonaDao;
import com.contactos.agenda.app.entities.Contacto;

@Service
public class ContactoServiceImpl implements IContactoService {

	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contacto> listarUsuarios() {
		return (List<Contacto>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void guardarContacto(Contacto contacto) {
		personaDao.save(contacto);
	}

	@Override
	@Transactional
	public void eliminarContacto(Contacto contacto) {
		personaDao.delete(contacto);
	}

	@Override
	@Transactional(readOnly = true)
	public Contacto editarContacto(Contacto contacto) {
		return personaDao.findById(contacto.getIdContacto()).orElse(null);
	}

}
