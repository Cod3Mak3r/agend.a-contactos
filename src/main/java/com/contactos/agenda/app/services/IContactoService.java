package com.contactos.agenda.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contactos.agenda.app.entities.Contacto;


public interface IContactoService {
	
	public List<Contacto> listarContactos();
	public void guardarContacto(Contacto contacto);
	public void eliminarContacto(Contacto contacto);
	public Contacto buscarContacto(Contacto contacto);
	
}
