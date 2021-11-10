package com.contactos.agenda.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.agenda.app.entities.Contacto;
import com.contactos.agenda.app.services.IContactoService;

@RestController
@RequestMapping("/api/contactos/")
public class ContactoControllerRest {
	
	private IContactoService contactoService;
	
	@GetMapping("/list")
	public String listarContactos(Model model) {
		var contactos = contactoService.listarContactos();
		model.addAttribute("contactos", contactos);
		return "list";
	}
	
	@GetMapping("/form")
	public String mostrarFormulario() {
		return "form";
	}
	
	@PostMapping("/save")
	public String guardarContacto(Contacto contacto) {
		contactoService.guardarContacto(contacto);
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{id}")
	public String buscarContacto(@PathVariable(name="id") Long id  ,
										Model model, Contacto contacto) {
		var contactos = contactoService.buscarContacto(contacto);
		model.addAttribute("contactos", contacto);
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarContacto(@PathVariable(name="id") Long id,
													Contacto contacto) {
		contactoService.eliminarContacto(contacto);
		return "redirect:/list";
	}
	
	
	
	
	
}
