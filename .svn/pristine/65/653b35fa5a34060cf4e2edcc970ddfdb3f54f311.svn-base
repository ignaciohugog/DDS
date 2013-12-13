package util.test;


import java.util.Collection;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import util.UFiltro;
import domain.Asiento;
import domain.Clase;
import domain.Ubicacion;
import domain.asiento.clase.ClaseTurista;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.ubicacion.UbicacionPasillo;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.usuarios.UsuarioEstandar;
import domain.usuarios.UsuarioVIP;

public class UFiltroTest
{
	Collection<Asiento> coleccionDeAsientos;
	UsuarioVIP usuarioVip;
	UsuarioEstandar usuarioEstandar;
	
	@Before
	public void setUp() throws Exception
	{
		coleccionDeAsientos = new Vector<Asiento>();
		
		Asiento asiento1 = new Asiento();
		asiento1.setClase(new PrimeraClase());
		asiento1.setUbicacion(new UbicacionPasillo());
		asiento1.setPrecioTotal(700);
		coleccionDeAsientos.add(asiento1);
		
		
		Asiento asiento2 = new Asiento();
		asiento2.setClase(new ClaseTurista());
		asiento2.setUbicacion(new UbicacionVentana());
		asiento2.setPrecioTotal(800);
		coleccionDeAsientos.add(asiento2);
		
		Asiento asiento3 = new Asiento();
		asiento3.setClase(new ClaseTurista());
		asiento3.setUbicacion(new UbicacionPasillo());
		asiento3.setPrecioTotal(850);
		coleccionDeAsientos.add(asiento3);
		
		usuarioVip = new UsuarioVIP();
		usuarioEstandar = new UsuarioEstandar();
	}

	@Test
	public void filtrarPorPrecioTest()
	{
		double precioMin = 700;
		double precioMax = 800;
		
		coleccionDeAsientos = UFiltro.filtrarAsientos(null, null, precioMin, precioMax, false, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}	
	
	@Test
	public void filtrarPorClaseTest()
	{
		Clase unaClase = new ClaseTurista();
		List<Clase> clasesElegidas = new Vector<Clase>();
		clasesElegidas.add(unaClase);
		
		coleccionDeAsientos = UFiltro.filtrarAsientos(clasesElegidas, null, 0, 0, false, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
	
	@Test
	public void filtrarPorUbicacionTest()
	{
		Ubicacion ubicacionElegida = new UbicacionPasillo();
		coleccionDeAsientos = UFiltro.filtrarAsientos(null, ubicacionElegida, 0, 0, false, coleccionDeAsientos, usuarioVip);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
	
	@Test
	public void filtrarPorSuperOfertasTest()
	{
		coleccionDeAsientos = UFiltro.filtrarAsientos(null, null, 0, 0, false, coleccionDeAsientos, usuarioEstandar);
		Assert.assertTrue("El resultado deberia ser 2 asientos", coleccionDeAsientos.size() == 2);
	}
}
