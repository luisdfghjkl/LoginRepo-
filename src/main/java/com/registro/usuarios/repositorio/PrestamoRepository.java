package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.registro.usuarios.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {

	  @Query(value = "SELECT * FROM prestamo WHERE Id_Cliente = ?1", nativeQuery = true)
	    List<Prestamo> obtenerPrestamosPorIdCliente(Long idCliente);
	
}
