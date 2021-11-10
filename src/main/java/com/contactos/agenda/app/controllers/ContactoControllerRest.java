package com.contactos.agenda.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.agenda.app.entities.Contacto;
import com.contactos.agenda.app.services.IContactoService;

@RestController
@RequestMapping("/api/contactos")
public class ContactoControllerRest {
	
	@Autowired
	private IContactoService contactoService;
	
	//Create a new contact
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Contacto contacto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(contactoService.guardarContacto(contacto));
	}
	
	//Read an contact
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		var contactos = contactoService.buscarContacto(id);
		 
		if (contactos == null) {
				return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(contactos);
	}
	
	
	
	
	
}
