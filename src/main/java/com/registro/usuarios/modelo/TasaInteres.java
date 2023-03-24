package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasaInteres")
public class TasaInteres {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int plazo_min;
	private int plazo_max;
	private float tasa_interes;
	
	public int getPlazo_min() {
		return plazo_min;
	}
	public void setPlazo_min(int plazo_min) {
		this.plazo_min = plazo_min;
	}
	public int getPlazo_max() {
		return plazo_max;
	}
	public void setPlazo_max(int plazo_max) {
		this.plazo_max = plazo_max;
	}
	public float getTasa_interes() {
		return tasa_interes;
	}
	public void setTasa_interes(float tasa_interes) {
		this.tasa_interes = tasa_interes;
	}
	public TasaInteres(int plazo_min, int plazo_max, float tasa_interes) {
		super();
		this.plazo_min = plazo_min;
		this.plazo_max = plazo_max;
		this.tasa_interes = tasa_interes;
	}
	public TasaInteres() {
		super();
	}
	
	

}
