package com.registro.usuarios.servicio;

import java.util.Date;
import java.util.List;

import com.registro.usuarios.modelo.Prestamo;

public interface PrestamoServicio {

	public List<Prestamo>prestamoPorCliente(Long id);
	
}
