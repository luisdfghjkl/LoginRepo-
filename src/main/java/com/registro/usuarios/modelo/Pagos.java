package com.registro.usuarios.modelo;

public class Pagos {
	
	int plazo;
	float tasa_interes = (float) .065;
	float interes;
	float pago;
	float iva;
	float monto;
	
	
	public int getPlazo() {
		return plazo;
	}


	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}


	public float getTasa_interes() {
		return tasa_interes;
	}


	public void setTasa_interes(float tasa_interes) {
		this.tasa_interes = tasa_interes;
	}


	public float getInteres() {
		return interes;
	}


	public void setInteres(float interes) {
		this.interes = interes;
	}


	public float getPago() {
		return pago;
	}


	public void setPago(float pago) {
		this.pago = pago;
	}


	public float getIva() {
		return iva;
	}


	public void setIva(float iva) {
		this.iva = iva;
	}


	public float getMonto() {
		return monto;
	}


	public void setMonto(float monto) {
		this.monto = monto;
	}


	public Pagos(int plazo, float tasa_interes, float interes, float pago, float iva, float monto) {
		super();
		this.plazo = plazo;
		this.tasa_interes = tasa_interes;
		this.interes = interes;
		this.pago = pago;
		this.iva = iva;
		this.monto = monto;
	}


	@Override
	public String toString() {
		return "Pagos [plazo=" + plazo + ", tasa_interes=" + tasa_interes + ", interes=" + interes + ", pago=" + pago
				+ ", iva=" + iva + ", monto=" + monto + "]";
	}
	
	
	
}
