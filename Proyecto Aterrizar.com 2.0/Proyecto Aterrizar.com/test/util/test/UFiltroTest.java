package util.test;


import java.util.Collection;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import util.UFiltro;
import domain.Asiento;
import domain.Busqueda;
import domain.Clase;
import domain.Estado;
import domain.Ubicacion;
import domain.asiento.clase.ClaseEjecutiva;
import domain.asiento.clase.ClaseTurista;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.estado.EstadoComprado;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.estado.EstadoReservado;
import domain.asiento.ubicacion.UbicacionPasillo;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.usuarios.UsuarioEstandar;
import domain.usuarios.UsuarioVIP;

public class UFiltroTest
{
	Collection<Asiento> coleccionDeAsientos;
	UsuarioVIP usuarioVip;
	UsuarioEstandar usuarioEstandar;
	Busqueda busqueda;
	
	@Before
	public void setUp() throws Exception
	{
		busqueda = new Busqueda();
		busqueda.setClases(null);
		busqueda.setUbicacion(null);
		busqueda.setPrecioMinimo(null);
		busqueda.setPrecioMaximo(null);
		
		coleccionDeAsientos = new Vector<Asiento>();
		
		Asiento asiento1 = new Asiento();
		asiento1.setClase(new PrimeraClase());
		asiento1.setUbicacion(new UbicacionPasillo());
		asiento1.setPrecioTotal(700);
		asiento1.setEstado(new EstadoDisponible());
		coleccionDeAsientos.add(asiento1);
		
		
		Asiento asiento2 = new Asiento();
		asiento2.setClase(new ClaseTurista());
		asiento2.setUbicacion(new UbicacionVentana());
		asiento2.setPrecioTotal(2000);
		asiento2.setEstado(new EstadoReservado());
		coleccionDeAsientos.add(asiento2);
		
		Asiento asiento3 = new Asiento();
		asiento3.setClase(new ClaseTurista());
		asiento3.setUbicacion(new UbicacionPasillo());
		asiento3.setPrecioTotal(5000);
		asiento3.setEstado(new EstadoComprado());
		coleccionDeAsientos.add(asiento3);
		
		Asiento asiento4 = new Asiento();
		asiento4.setClase(new ClaseEjecutiva());
		asiento4.setUbicacion(new UbicacionVentana());
		asiento4.setPrecioTotal(1000);
		asiento4.setEstado(new EstadoComprado());
		coleccionDeAsientos.add(asiento4);
		
		
		usuarioVip = new UsuarioVIP();
		usuarioEstandar = new UsuarioEstandar();
	}

	
	@Test
	public void filtrarPorUnaClaseTest()
	{
		Collection<Clase> clasesElegidas = new Vector<Clase>();
		clasesElegidas.add(new ClaseTurista());
		busqueda.setClases(clasesElegidas);
		
		coleccionDeAsientos = UFiltro.filtrarAsientos(busqueda, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
	
	@Test
	public void filtrarPorVariasClasesTest()
	{
		Collection<Clase> clasesElegidas = new Vector<Clase>();
		clasesElegidas.add(new ClaseEjecutiva());
		clasesElegidas.add(new PrimeraClase());
		busqueda.setClases(clasesElegidas);
		
		coleccionDeAsientos = UFiltro.filtrarAsientos(busqueda, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
	
	@Test
	public void filtrarPorUbicacionTest()
	{
		Ubicacion ubicacionElegida = new UbicacionPasillo();
		busqueda.setUbicacion(ubicacionElegida);
		coleccionDeAsientos = UFiltro.filtrarAsientos(busqueda, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
	
	@Test
	public void filtrarPorSuperOfertasTest()
	{
		coleccionDeAsientos = UFiltro.filtrarAsientos(busqueda, coleccionDeAsientos, usuarioEstandar);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
	
	@Test
	public void filtrarPorPrecioTest()
	{
		busqueda.setPrecioMaximo(1100);
		busqueda.setPrecioMinimo(10);
		
		coleccionDeAsientos = UFiltro.filtrarAsientos(busqueda, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
	
	@Test
	public void filtrarPorEstadoTest()
	{
		Collection<Estado> estadosElegidos = new Vector<Estado>();
		estadosElegidos.add(new EstadoDisponible());
		estadosElegidos.add(new EstadoReservado());
		busqueda.setEstados(estadosElegidos);
		
		coleccionDeAsientos = UFiltro.filtrarAsientos(busqueda, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
}
