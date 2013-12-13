package aerolinea.test;

import java.util.Collection;
import java.util.Vector;

import junit.framework.Assert;
import mock.AerolineaLanchitaMock;

import org.junit.Before;
import org.junit.Test;

import criteriosDeOrdenamiento.imple.SinCriterio;

import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;
import domain.Asiento;
import domain.Busqueda;
import domain.Ciudad;
import domain.Clase;
import domain.Ubicacion;
import domain.Usuario;
import domain.aerolinea.imple.AerolineaLanchitaImple;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.exception.AsientoNoDisponibleException;
import domain.usuarios.UsuarioVIP;

public class AerolineaLanchitaImpleTest
{
	Asiento asiento;
	Asiento asientoQueNoEstaDisponible;
	Asiento asientoQueNoExiste;
	Collection<Asiento> coleccionDeAsientos;
	AerolineaLanchitaImple lanchitaImple;
	Busqueda busqueda;
	Usuario usuario;

	@Before
	public void setUp() throws Exception
	{
		coleccionDeAsientos = new Vector<Asiento>();
		lanchitaImple = new AerolineaLanchitaImple();
		lanchitaImple.setInstancia(new AerolineaLanchitaMock());

		Fecha fechaSalida = UFecha.convertirAFecha("20/12/2012");
		Fecha fechaLlegada = UFecha.convertirAFecha("21/12/2012");
		Hora horaSalida = UFecha.convertirAHora("14:00");
		Hora horaLlegada = UFecha.convertirAHora("02:25");

		asiento = new Asiento(lanchitaImple, "01202022220202", 3,
				fechaSalida, fechaLlegada, horaSalida, horaLlegada, 159.90, 0, 
				new PrimeraClase(), new UbicacionVentana(), new EstadoDisponible());

		asientoQueNoEstaDisponible = new Asiento(lanchitaImple, 
				"Tira un EstadoErroneoException", 0, 
				fechaSalida, fechaLlegada, horaSalida, horaLlegada, 159.90, 0, 
				new PrimeraClase(),	new UbicacionVentana(), new EstadoDisponible());

		asientoQueNoExiste = new Asiento(lanchitaImple, 
				"Tira un CodigoErroneoException", 0, 
				fechaSalida, fechaLlegada, horaSalida, horaLlegada, 159.90, 0, 
				new PrimeraClase(),	new UbicacionVentana(), new EstadoDisponible());

		
		Ciudad buenosAires = new Ciudad("Buenos Aires");
		Ciudad losAngeles = new Ciudad("Los Angeles");
		Fecha fechaSalida2 = UFecha.convertirAFecha("15/08/2012");
		Hora horaSalida2 = UFecha.convertirAHora("15:35");
		Fecha fechaLlegada2 = UFecha.convertirAFecha("17/08/2012");
		Hora horaLlegada2 = UFecha.convertirAHora("17:35");
		Collection<Clase> claseNula = null;
		Ubicacion ubicacionNula = null;

		busqueda = new Busqueda(buenosAires, losAngeles, 
				fechaSalida2, horaSalida2, fechaLlegada2, horaLlegada2, 
				claseNula, ubicacionNula, null, null, new SinCriterio(), null, null);

		usuario = new UsuarioVIP();
		usuario.setNombre("Pepe");
		usuario.setApellido("Gonzalez");
		usuario.setDni(12345678);
	}

	@Test
	public void obtenerAsientosDisponiblesTest()
	{
		coleccionDeAsientos = lanchitaImple.obtenerAsientosDisponibles(busqueda, usuario);
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
			lanchitaImple.comprarAsiento(asiento, usuario);
		}
		catch(Exception e)
		{
			Assert.fail("La reserva ha lanzado una excepcion");
		}
	}

	@Test(expected = AsientoNoDisponibleException.class)
	public void comprarUnAsientoQueNoEstaDisponibleTest()
	{
		lanchitaImple.comprarAsiento(asientoQueNoEstaDisponible, usuario);
	}
	
	@Test(expected = AsientoNoDisponibleException.class)
	public void comprarUnAsientoQueNoExiste()
	{
		lanchitaImple.comprarAsiento(asientoQueNoExiste, usuario);
	}

	/*
	 * RESERVA
	 */

	@Test
	public void reservarUnAsientoTest()
	{
		try
		{
			lanchitaImple.reservarAsiento(asiento, usuario);
		}
		catch(Exception e)
		{
			Assert.fail("La reserva ha lanzado una excepcion");
		}
	}

	@Test(expected = AsientoNoDisponibleException.class)
	public void reservarUnAsientoQueNoEstaDisponibleTest()
	{
		lanchitaImple.reservarAsiento(asientoQueNoEstaDisponible, usuario);
	}
	
	@Test(expected = AsientoNoDisponibleException.class)
	public void reservarUnAsientoQueNoExiste()
	{
		lanchitaImple.reservarAsiento(asientoQueNoExiste, usuario);
	}

}
