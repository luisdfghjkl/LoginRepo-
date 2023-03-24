package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImp implements ClienteServicio{

	
	@Autowired
	private ClienteRepositorio repositorio;
	
	@Override
	public List<Cliente> ListarTodosLosClientes() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}
	
	

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		 return repositorio.save(cliente);
	}



	@Override
	public Optional<Cliente> buscarPorId(long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repositorio.getById(id));
	}









}
