package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;

import com.registro.usuarios.modelo.Cliente;

public interface ClienteServicio {
	
	public List <Cliente> ListarTodosLosClientes();
	public Cliente guardarCliente(Cliente cliente);
	public Optional<Cliente> buscarPorId(long id);
}
