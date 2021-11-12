package com.contactos.agenda.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contactos.agenda.app.entities.Contacto;


public interface IContactoService {
	
	public List<Contacto> listarContactos();
	public Contacto guardarContacto(Contacto contacto);
	public void eliminarContacto(Long id);
	public Contacto buscarContacto(Long id);
	
}
