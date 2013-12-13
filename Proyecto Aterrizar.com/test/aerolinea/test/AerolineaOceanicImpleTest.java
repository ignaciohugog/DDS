package aerolinea.test;


import java.util.Collection;
import java.util.Vector;

import junit.framework.Assert;

import mock.AerolineaOceanicMock;

import org.junit.Before;
import org.junit.Test;

import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;
import domain.Asiento;
import domain.Busqueda;
import domain.Ciudad;
import domain.Clase;
import domain.Ubicacion;
import domain.Usuario;
import domain.aerolinea.imple.AerolineaOceanicImple;
import domain.asiento.clase.ClaseEjecutiva;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.estado.EstadoComprado;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.ubicacion.UbicacionPasillo;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.exception.AsientoNoDisponibleException;
import domain.usuarios.UsuarioVIP;

public class AerolineaOceanicImpleTest
{
	
	Asiento asiento;
	Asiento asientoQueNoEstaDisponible;
	Asiento asientoQueNoExiste;
	Collection<Asiento> coleccionDeAsientos;
	AerolineaOceanicImple oceanicImple;
	Busqueda busqueda;
	Usuario usuario;

	
	@Before
	public void setUp() throws Exception
	{
		coleccionDeAsientos = new Vector<Asiento>();
		oceanicImple = new AerolineaOceanicImple();
		oceanicImple.setInstancia(new AerolineaOceanicMock());

		Fecha fechaSalida = UFecha.convertirAFecha("20/12/2012");
		Fecha fechaLlegada = UFecha.convertirAFecha("21/12/2012");
		Hora horaSalida = UFecha.convertirAHora("14:00");
		Hora horaLlegada = UFecha.convertirAHora("02:25");

		asiento = new Asiento(oceanicImple, "OC100", 10,
				fechaSalida, fechaLlegada, horaSalida, horaLlegada, 159.90, 0, 
				new ClaseEjecutiva(), new UbicacionPasillo(), new EstadoDisponible());

		asientoQueNoEstaDisponible = new Asiento(oceanicImple, 
				"Asiento no disponible", 0, 
				fechaSalida, fechaLlegada, horaSalida, horaLlegada, 159.90, 0, 
				new PrimeraClase(),	new UbicacionVentana(), new EstadoComprado());

		asientoQueNoExiste = new Asiento(oceanicImple, 
				"Asiento inexistente", 0, 
				fechaSalida, fechaLlegada, horaSalida, horaLlegada, 159.90, 0, 
				new PrimeraClase(),	new UbicacionVentana(), new EstadoDisponible());

		
		Ciudad buenosAires = new Ciudad("Buenos Aires");
		Ciudad losAngeles = new Ciudad("Los Angeles");
		Fecha fechaSalida2 = UFecha.convertirAFecha("15/08/2012");
		Hora horaSalida2 = UFecha.convertirAHora("15:35");
		Fecha fechaLlegada2 = UFecha.convertirAFecha("17/08/2012");
		Hora horaLlegada2 = UFecha.convertirAHora("17:35");
		Clase claseNula = null;
		Ubicacion ubicacionNula = null;

		busqueda = new Busqueda(buenosAires, losAngeles, 
				fechaSalida2, horaSalida2, fechaLlegada2, horaLlegada2, 
				claseNula, ubicacionNula, 0, 0, false);

		usuario = new UsuarioVIP();
		usuario.setNombre("Pepe");
		usuario.setApellido("Gonzalez");
		usuario.setDni(12345678);

	}
	
	@Test
	public void obtenerAsientosDisponiblesTest()
	{
		coleccionDeAsientos = oceanicImple.obtenerAsientosDisponibles(busqueda, usuario);
		Assert.assertTrue("Deberia haber encontrado asientos", !coleccionDeAsientos.isEmpty());
	}

	/*
	 * COMPRA
	 */

	@Test
	public void comprarUnAsientoTest()
	{
		try
		{
			oceanicImple.comprarAsiento(asiento, usuario);
		}
		catch(Exception e)
		{
			Assert.fail("La reserva ha lanzado una excepcion");
		}
	}

	@Test(expected = AsientoNoDisponibleException.class)
	public void comprarUnAsientoQueNoEstaDisponibleTest()
	{
		oceanicImple.comprarAsiento(asientoQueNoEstaDisponible, usuario);
	}
	
	@Test(expected = AsientoNoDisponibleException.class)
	public void comprarUnAsientoQueNoExiste()
	{
		oceanicImple.comprarAsiento(asientoQueNoExiste, usuario);
	}

	/*
	 * RESERVA
	 */

	@Test
	public void reservarUnAsientoTest()
	{
		try
		{
			oceanicImple.reservarAsiento(asiento, usuario);
		}
		catch(Exception e)
		{
			Assert.fail("La reserva ha lanzado una excepcion");
		}
	}

	
	@Test(expected = AsientoNoDisponibleException.class)
	public void reservarUnAsientoQueNoEstaDisponibleTest()
	{
		oceanicImple.reservarAsiento(asientoQueNoEstaDisponible, usuario);
	}
	
	@Test(expected = AsientoNoDisponibleException.class)
	public void reservarUnAsientoQueNoExiste()
	{
		oceanicImple.reservarAsiento(asientoQueNoExiste, usuario);
	}

	

}
