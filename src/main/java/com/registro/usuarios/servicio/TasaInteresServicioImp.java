package com.registro.usuarios.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.repositorio.TasaInteresRepositorio;
@Service
public class TasaInteresServicioImp implements TasaInteresServicio {

	@Autowired
	private TasaInteresRepositorio tasa;
	
	@Override
	public float buscarTasaInteres(int plazo) {
		// TODO Auto-generated method stub
		float tasa_interes= tasa.findByPlazo(plazo);
		return tasa_interes;
	}

}
