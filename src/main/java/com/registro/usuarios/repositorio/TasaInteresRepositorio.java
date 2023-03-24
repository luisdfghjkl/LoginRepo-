package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.TasaInteres;

@Repository
public interface TasaInteresRepositorio extends JpaRepository<TasaInteres,Long>{

	@Query(value = "SELECT tasa_interes FROM tasa_interes WHERE plazo_min <= ?1 AND plazo_max >= ?1", nativeQuery = true)
	public float findByPlazo(int plazo);
}
