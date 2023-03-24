package com.registro.usuarios.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Pagos;
import com.registro.usuarios.modelo.Prestamo;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.PrestamoServicio;
import com.registro.usuarios.servicio.TasaInteresServicio;

@Controller
public class PrestamoController {
	
	@Autowired
	private PrestamoServicio prestamo;
	
	@Autowired 
	private ClienteServicio clienteServicio;
	
	@Autowired 
	private TasaInteresServicio tasaServicio;
	
	@GetMapping("/mostrar/{id}")
	public String mostrarPrestamos (@PathVariable Long id, Model modelo) {
		
		  List<Prestamo> prestamos = prestamo.prestamoPorCliente(id);
		  Optional<Cliente> clienteOptional = clienteServicio.buscarPorId(id);
		    if (clienteOptional.isPresent()) {
		      Cliente cliente = clienteOptional.get();
		      modelo.addAttribute("cliente", cliente);
		    }
	        modelo.addAttribute("prestamos", prestamos);
	return "prestamos";
	}
	
	
	@PostMapping("/calcular/{id}")
	public String calcularPrestamos (@PathVariable Long id, Model modelo) {
		
		List<Prestamo> prestamos = prestamo.prestamoPorCliente(id);
		 
		  Optional<Cliente> clienteOptional = clienteServicio.buscarPorId(id);
		    if (clienteOptional.isPresent()) {
		      Cliente cliente = clienteOptional.get();
		      modelo.addAttribute("cliente", cliente);
		    }
		List <Pagos> pagosLista = new ArrayList<>();;
		
		for (Prestamo prestamo: prestamos ) {
			int plazo;
			int dias_ano_comercial = 360;
			float tasa_interes;
			float interes;
			float pago;
			float tasa_iva = (float) .16;
			float iva;
			
			Date fecha= prestamo.getFecha();
			float monto= prestamo.getMonto();
			
			plazo = prestamo.plazo(fecha);
			tasa_interes= tasaServicio.buscarTasaInteres(plazo);
			//System.out.println("Hola, esto es un mensaje en consola: "+plazo);
			interes = prestamo.Interes(monto, plazo, tasa_interes, dias_ano_comercial);
			iva = prestamo.iva(interes, tasa_iva);
			pago = prestamo.pago(monto, interes, iva);
			
			Pagos pagos=new Pagos(plazo,tasa_interes,monto,interes,iva,pago);
			
			pagosLista.add(pagos);
			
		
		}	
		modelo.addAttribute("pagosLista", pagosLista);
		System.out.print(pagosLista);
		return "pagos";
	}
	
	
	
}
