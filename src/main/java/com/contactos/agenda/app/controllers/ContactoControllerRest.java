package com.contactos.agenda.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.agenda.app.entities.Contacto;
import com.contactos.agenda.app.services.IContactoService;

@RestController
@RequestMapping("/api/v1/contactos")
public class ContactoControllerRest {

	@Autowired
	private IContactoService contactoService;

	// List all contacts
	@GetMapping
	public List<Contacto> list() {
		return contactoService.listarContactos();
	}

	// Read an contact
	@GetMapping("/{id}")
	public ResponseEntity<Contacto> find(@PathVariable Long id) {
		var contacto = contactoService.buscarContacto(id);
		if (contacto == null) {return ResponseEntity.notFound().build();}
		return ResponseEntity.ok(contacto);
	}

	// Create a new contact
	@PostMapping
	public ResponseEntity<Contacto> create(@RequestBody Contacto contacto) {
		Contacto contact = contactoService.guardarContacto(contacto);
		return new ResponseEntity<Contacto>(contact, HttpStatus.OK);
	}

	// Update an contact
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Contacto> update(@PathVariable Long id, 
											@RequestBody Contacto contacto) {
		contactoService.buscarContacto(id);
		Contacto contact = contactoService.actualizarContacto(contacto);
		return new ResponseEntity<Contacto>(contact, HttpStatus.OK);
	}

	// Delete an contact
	@DeleteMapping("/{id}")
	public ResponseEntity<Contacto> delete(@PathVariable Long id) {
		Contacto contact = contactoService.buscarContacto(id);
		if (contact != null) {
			contactoService.eliminarContacto(id);
		} else {
			return new ResponseEntity<Contacto>(contact, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Contacto>(contact, HttpStatus.OK);
	}

}
