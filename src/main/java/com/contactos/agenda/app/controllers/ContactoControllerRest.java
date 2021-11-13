package com.contactos.agenda.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.agenda.app.entities.Contacto;
import com.contactos.agenda.app.services.IContactoService;

@RestController
@RequestMapping("/api/v1/contactos")
public class ContactoControllerRest {
	
	@Autowired
	private IContactoService contactoService;
	
	//List all contacts
	@GetMapping("/list")
	public List<Contacto> list(){
		return contactoService.listarContactos();
	}
	
	
	//Create and update a new contact
	@PostMapping("/save")
	public ResponseEntity<Contacto> create(@RequestBody Contacto contacto){
		Contacto contact  = contactoService.guardarContacto(contacto);
		return new ResponseEntity<Contacto>(contact, HttpStatus.OK);	
	}
	
	//Read an contact
	@GetMapping("/find/{id}")
	public ResponseEntity<Contacto> find(@PathVariable Long id){
		var contacto = contactoService.buscarContacto(id);
		 
		if (contacto == null ) 
		{return ResponseEntity.notFound().build();}
		
		return ResponseEntity.ok(contacto);
	}
	
	//Delete an contact
	@PostMapping("/delete/{id}")
	public ResponseEntity<Contacto> delete(@PathVariable Long id){
		Contacto contact = contactoService.buscarContacto(id);
		if (contact != null) {contactoService.eliminarContacto(id);}
		else
		{ return new ResponseEntity<Contacto>
							(contact, HttpStatus.INTERNAL_SERVER_ERROR);}
		
		return new ResponseEntity<Contacto>(contact, HttpStatus.OK);
	}
	
	
	
}
