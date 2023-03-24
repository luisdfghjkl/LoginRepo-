package com.registro.usuarios.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name = "prestamo")
public class Prestamo {

 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private Date Fecha;
    private float Monto;
    private String Estado;

    @ManyToOne
    @JoinColumn(name = "Id_Cliente")
    private Cliente cliente;
    //getters and setters

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public float getMonto() {
		return Monto;
	}

	public void setMonto(float monto) {
		Monto = monto;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prestamo(int id, Date fecha, float monto, String estado, Cliente cliente) {
		super();
		Id = id;
		Fecha = fecha;
		Monto = monto;
		Estado = estado;
		this.cliente = cliente;
	}

	public Prestamo(Date fecha, float monto, String estado, Cliente cliente) {
		super();
		Fecha = fecha;
		Monto = monto;
		Estado = estado;
		this.cliente = cliente;
	}
     
	public Prestamo() {
		super();
	}

	public int plazo(Date prestamo_fecha) {

		Date fecha_actual = new Date(121, 2, 15);

		int dias = (int) ((fecha_actual.getTime() - prestamo_fecha.getTime()) / 86400000);
		return dias;
	}

	public float Interes(float monto2, int plazo, float tasa_interes, int dias_ano_comercial) {
		// TODO Auto-generated method stub
		float interes;
		interes = (monto2 * plazo * tasa_interes) / dias_ano_comercial;
		double num = interes;
		double roundedNum = Math.round(num * 100.0) / 100.0;

		return (float) roundedNum;
	}

	public float iva(float interes, float tasa_iva) {
		float iva;
		iva = interes * tasa_iva;
		double num = iva;
		double roundedNum = Math.round(num * 100.0) / 100.0;
		return (float) roundedNum;
	}

	public float pago(float monto2, float interes, float iva) {
		float pago;
		pago = monto2 + interes + iva;
		return pago;
	}

}