package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.PrestamoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	
	@Autowired
	private ClienteServicio servicio;

	
	
	@GetMapping("/login")
	public String iniciarSesion() {
		
		return "login";
	}
	@GetMapping("/")
	public String verPaginaInicio(Model modelo) {
		
		modelo.addAttribute("clientes",servicio.ListarTodosLosClientes());
		return "index";
	}
	
	
	
	
	
	
}
