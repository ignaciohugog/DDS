package aterrizar.test;


import java.util.Collection;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import util.UFactory;
import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;
import app.Aterrizar;
import app.imple.AterrizarImple;
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
import domain.usuarios.UsuarioVIP;

public class AterrizarImpleTest
{
	Aterrizar aterrizar;
	Asiento asiento;
	Asiento asientoQueNoEstaDisponible;
	Asiento asientoQueNoExiste;
	Collection<Asiento> coleccionDeAsientos;
	Busqueda busqueda;
	Usuario usuario;

	@Before
	public void setUp() throws Exception
	{
		aterrizar = new AterrizarImple();
		coleccionDeAsientos = new Vector<Asiento>();
		
		AerolineaLanchitaImple aeroLanchita = (AerolineaLanchitaImple) UFactory.getInstancia("LANCHITA");
		Fecha fechaSalida = UFecha.convertirAFecha("20/12/2012");
		Fecha fechaLlegada = UFecha.convertirAFecha("21/12/2012");
		Hora horaSalida = UFecha.convertirAHora("14:00");
		Hora horaLlegada = UFecha.convertirAHora("02:25");

		asiento = new Asiento(aeroLanchita, "01202022220202", 3, fechaSalida, fechaLlegada, horaSalida, horaLlegada, 159.90, 0, new PrimeraClase(), new UbicacionVentana(), new EstadoDisponible());
		
		Ciudad buenosAires = new Ciudad("Buenos Aires");
		Ciudad losAngeles = new Ciudad("Los Angeles");
		Fecha fechaSalida2 = UFecha.convertirAFecha("15/08/2012");
		Hora horaSalida2 = UFecha.convertirAHora("15:35");
		Fecha fechaLlegada2 = UFecha.convertirAFecha("17/08/2012");
		Hora horaLlegada2 = UFecha.convertirAHora("17:35");
		Clase claseNula = null;
		Ubicacion ubicacionNula = null;

		busqueda = new Busqueda(buenosAires, losAngeles, fechaSalida2, horaSalida2, fechaLlegada2, horaLlegada2, claseNula, ubicacionNula, 0, 0, false);

		usuario = new UsuarioVIP();
		usuario.setNombre("Pepe");
		usuario.setApellido("Gonzalez");
		usuario.setDni(12345678);
		
	}
	
	@Test
	public void obtenerAsientosTest()
	{
		coleccionDeAsientos = aterrizar.obtenerAsientosDisponibles(busqueda, usuario);
		Assert.assertTrue(!coleccionDeAsientos.isEmpty());
	}
	
	
}
