package com.registro.usuarios.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.modelo.Prestamo;
import com.registro.usuarios.repositorio.PrestamoRepository;

@Service
public class PrestamoServiceImp implements PrestamoServicio{

	@Autowired
	private PrestamoRepository prestamo;
	
	@Override
	public List<Prestamo> prestamoPorCliente(Long id) {
		// TODO Auto-generated method stub
		
		return prestamo.obtenerPrestamosPorIdCliente(id);
	}



}
