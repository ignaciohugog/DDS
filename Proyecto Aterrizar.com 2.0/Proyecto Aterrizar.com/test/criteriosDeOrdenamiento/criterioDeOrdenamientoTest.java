package criteriosDeOrdenamiento;

import java.util.Collection;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import util.UFecha;

import baseDeDatos.VuelosBD;
import criterioDeOrdenamiento.Criterio;
import criteriosDeOrdenamiento.imple.CriterioPopularidad;
import criteriosDeOrdenamiento.imple.CriterioPrecio;
import criteriosDeOrdenamiento.imple.CriterioTiempoDeVuelo;
import domain.Asiento;
import domain.Busqueda;
import domain.asiento.clase.ClaseEjecutiva;
import domain.asiento.clase.ClaseTurista;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.estado.EstadoComprado;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.estado.EstadoReservado;
import domain.asiento.ubicacion.UbicacionPasillo;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.usuarios.UsuarioVIP;

public class criterioDeOrdenamientoTest
{
	Collection<Asiento> coleccionDeAsientos;
	UsuarioVIP usuarioVip;
	Busqueda busqueda;
	Criterio criterio;
	
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
		asiento1.setCodigoVuelo("01");
		asiento1.setClase(new PrimeraClase());
		asiento1.setUbicacion(new UbicacionPasillo());
		asiento1.setPrecioTotal(700);
		asiento1.setEstado(new EstadoDisponible());
		asiento1.setFechaSalida(UFecha.convertirAFecha("12/10/12"));
		asiento1.setFechaLlegada(UFecha.convertirAFecha("12/10/12"));
		asiento1.setHoraSalida(UFecha.convertirAHora("11:00"));
		asiento1.setHoraLlegada(UFecha.convertirAHora("14:00"));
		coleccionDeAsientos.add(asiento1);
		
		
		Asiento asiento2 = new Asiento();
		asiento2.setCodigoVuelo("02");
		asiento2.setClase(new ClaseTurista());
		asiento2.setUbicacion(new UbicacionVentana());
		asiento2.setPrecioTotal(2000);
		asiento2.setEstado(new EstadoReservado());
		asiento2.setFechaSalida(UFecha.convertirAFecha("12/10/12"));
		asiento2.setFechaLlegada(UFecha.convertirAFecha("13/10/12"));
		asiento2.setHoraSalida(UFecha.convertirAHora("11:00"));
		asiento2.setHoraLlegada(UFecha.convertirAHora("14:00"));
		coleccionDeAsientos.add(asiento2);
		
		Asiento asiento3 = new Asiento();
		asiento3.setCodigoVuelo("01");
		asiento3.setClase(new ClaseTurista());
		asiento3.setUbicacion(new UbicacionPasillo());
		asiento3.setPrecioTotal(5000);
		asiento3.setEstado(new EstadoComprado());
		asiento3.setFechaSalida(UFecha.convertirAFecha("12/10/12"));
		asiento3.setFechaLlegada(UFecha.convertirAFecha("13/10/12"));
		asiento3.setHoraSalida(UFecha.convertirAHora("11:00"));
		asiento3.setHoraLlegada(UFecha.convertirAHora("10:00"));
		coleccionDeAsientos.add(asiento3);
		
		Asiento asiento4 = new Asiento();
		asiento4.setCodigoVuelo("03");
		asiento4.setClase(new ClaseEjecutiva());
		asiento4.setUbicacion(new UbicacionVentana());
		asiento4.setPrecioTotal(1000);
		asiento4.setEstado(new EstadoComprado());
		asiento4.setFechaSalida(UFecha.convertirAFecha("12/10/12"));
		asiento4.setFechaLlegada(UFecha.convertirAFecha("13/10/12"));
		asiento4.setHoraSalida(UFecha.convertirAHora("11:00"));
		asiento4.setHoraLlegada(UFecha.convertirAHora("08:00"));
		coleccionDeAsientos.add(asiento4);
		
		
		VuelosBD.agregarVuelo("01");
		
		VuelosBD.agregarVuelo("02");
		VuelosBD.obtenerVuelo("02").incrementarPopularidad();
		VuelosBD.obtenerVuelo("02").incrementarPopularidad();
		
		VuelosBD.agregarVuelo("03");
		VuelosBD.obtenerVuelo("03").incrementarPopularidad();
		
		
		usuarioVip = new UsuarioVIP();
	}

	@Test
	public void ordenarPorPrecioAscendenteTest()
	{
		criterio = new CriterioPrecio(true);
		busqueda.setCriterio(criterio);
		busqueda.getCriterio().aplicarCriterio(coleccionDeAsientos);
		
		double ultimoPrecio = 0;
		
		for(Asiento asiento : coleccionDeAsientos)
		{
			if(asiento.getPrecioTotal() < ultimoPrecio) Assert.fail("Sus precios estan en otro orden que no es por precio ascendente");
			ultimoPrecio = asiento.getPrecioTotal();
		}
	}
	
	@Test
	public void ordenarPorPrecioDescendenteTest()
	{
		criterio = new CriterioPrecio(false);
		busqueda.setCriterio(criterio);
		busqueda.getCriterio().aplicarCriterio(coleccionDeAsientos);
		
		double ultimoPrecio = 5000000;
		
		for(Asiento asiento : coleccionDeAsientos)
		{
			if(ultimoPrecio < asiento.getPrecioTotal()) Assert.fail("Sus precios estan en otro orden que no es por precio descendente");
			ultimoPrecio = asiento.getPrecioTotal();
		}
	}
	
	@Test
	public void ordenarPorPopularidadTest()
	{
		criterio = new CriterioPopularidad();
		busqueda.setCriterio(criterio);
		busqueda.getCriterio().aplicarCriterio(coleccionDeAsientos);
		
		String codigo;
		Integer popularidad;
		Integer ultimaPopularidad = 100000;
		
		for(Asiento asiento : coleccionDeAsientos)
		{
			codigo = asiento.getCodigoVuelo();
			popularidad = VuelosBD.obtenerVuelo(codigo).getPopularidad();
			
			if(ultimaPopularidad < popularidad)
			{
				Assert.fail("No estan ordenados ascendentemente por popularidad");
			}
			
			ultimaPopularidad = popularidad;
		}
	}
	
	
	@Test
	public void ordenarPorTiempoDeVueloTest()
	{
		criterio = new CriterioTiempoDeVuelo();
		busqueda.setCriterio(criterio);
		busqueda.getCriterio().aplicarCriterio(coleccionDeAsientos);
		
		long ultimoTiempo = -1;
		long tiempoDeVuelo;
		
		for(Asiento asiento : coleccionDeAsientos)
		{
			tiempoDeVuelo = UFecha.tiempoEntre(asiento.getFechaSalida(), asiento.getHoraSalida(), asiento.getFechaLlegada(), asiento.getHoraLlegada());
			if(tiempoDeVuelo < ultimoTiempo)
			{
				Assert.fail("No estan ordenados ascendentemente por tiempo de vuelo");
			}
			
			ultimoTiempo = tiempoDeVuelo;
		}
		
	}
}
