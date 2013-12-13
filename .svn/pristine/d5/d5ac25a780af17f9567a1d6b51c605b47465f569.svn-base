package dao.test;


import java.util.Collection;
import java.util.Vector;

import junit.framework.Assert;
import mock.AerolineaLanchitaMock;
import mock.AerolineaOceanicMock;

import org.junit.Before;
import org.junit.Test;

import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;
import criterioDeOrdenamiento.imple.SinCriterio;
import domain.Aerolinea;
import domain.Asiento;
import domain.Busqueda;
import domain.Ciudad;
import domain.Clase;
import domain.Ubicacion;
import domain.Usuario;
import domain.aerolinea.imple.AerolineaLanchitaImple;
import domain.aerolinea.imple.AerolineaOceanicImple;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.dao.imple.AerolineaDAOImple;
import domain.usuarios.UsuarioVIP;

public class AerolineaDAOTest
{
	Asiento asiento;
	Asiento asientoQueNoEstaDisponible;
	Asiento asientoQueNoExiste;
	Collection<Asiento> coleccionDeAsientos;
	AerolineaDAOImple dao;
	Busqueda busqueda;
	Usuario usuario;

	@Before
	public void setUp() throws Exception
	{
		Collection<Aerolinea> colAero = new Vector<Aerolinea>();
		coleccionDeAsientos = new Vector<Asiento>();
		
		AerolineaLanchitaImple lanchitaImple = new AerolineaLanchitaImple();
		lanchitaImple.setInstancia(new AerolineaLanchitaMock());
		colAero.add(lanchitaImple);
		
		AerolineaOceanicImple oceanicImple = new AerolineaOceanicImple();
		oceanicImple.setInstancia(new AerolineaOceanicMock());
		colAero.add(oceanicImple);
		
		dao = new AerolineaDAOImple();
		dao.setAerolineas(colAero);
		
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
	public void obtenerColeccionDeAsientosTest()
	{
		coleccionDeAsientos = dao.obtenerAsientosDisponibles(busqueda, usuario);
		Assert.assertTrue("El DAO deberia haber encontrado asientos", coleccionDeAsientos.size() == 6);
	}

}
