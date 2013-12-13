package criterios.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import domain.Asiento;
import criterioDeOrdenamiento.CriterioPrecio;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.asiento.ubicacion.UbicacionPasillo;
import domain.asiento.ubicacion.UbicacionCentro;
import util.fecha.Fecha;
import util.fecha.Hora;
import domain.aerolinea.imple.AerolineaLanchitaImple;
import domain.asiento.clase.ClaseEjecutiva;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.clase.ClaseTurista;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.estado.EstadoComprado;
import domain.asiento.estado.EstadoReservado;

public class Precio {

protected List<Asiento>retornoImpostor = new ArrayList<Asiento>();
	
	AerolineaLanchitaImple lanchitaImple = new AerolineaLanchitaImple();
	
	
	@Before
	public void setUp(){
		Fecha unaFecha = new Fecha();
		Hora unaHora = new Hora();
		Asiento unAsiento = new Asiento(lanchitaImple, "0202", 3,
				unaFecha, unaFecha, unaHora, unaHora, 150, 0, 
				new PrimeraClase(), new UbicacionVentana(), new EstadoDisponible());
		retornoImpostor.add(unAsiento);
		
		
		Asiento unAsiento1 = new Asiento(lanchitaImple, "03434", 67,
				unaFecha, unaFecha, unaHora, unaHora, 300, 877, 
				new PrimeraClase(), new UbicacionCentro(), new EstadoComprado());
		
		retornoImpostor.add(unAsiento1);
		
		Asiento unAsiento11 = new Asiento(lanchitaImple, "043", 345,
				unaFecha, unaFecha, unaHora, unaHora, 250, 333332, 
				new ClaseEjecutiva(), new UbicacionPasillo(), new EstadoReservado());
		retornoImpostor.add(unAsiento11);
		
		Asiento unAsiento111 = new Asiento(lanchitaImple, "0120", 3,
				unaFecha, unaFecha, unaHora, unaHora, 1000, 0, 
				new ClaseTurista(), new UbicacionCentro(), new EstadoComprado());
		retornoImpostor.add(unAsiento111);
	}
	
		
		
	
	
	@Test
	public void ordenoUnaListaPorPrecioAscendente(){
		CriterioPrecio unCriterio = new CriterioPrecio();
		unCriterio.setAscendente(true);
		Collections.sort(retornoImpostor,unCriterio);
		Assert.assertEquals(retornoImpostor.get(0).codigoVuelo,"0202");
		Assert.assertEquals(retornoImpostor.get(1).codigoVuelo,"043");
		Assert.assertEquals(retornoImpostor.get(2).codigoVuelo,"03434");
		Assert.assertEquals(retornoImpostor.get(3).codigoVuelo,"0120");
	}

	@Test
	public void ordenoUnaListaPorPrecioDescendente(){
		CriterioPrecio unCriterio = new CriterioPrecio();
		unCriterio.setAscendente(false);
		Collections.sort(retornoImpostor,unCriterio);
		Assert.assertEquals(retornoImpostor.get(3).codigoVuelo,"0202");
		Assert.assertEquals(retornoImpostor.get(2).codigoVuelo,"043");
		Assert.assertEquals(retornoImpostor.get(1).codigoVuelo,"03434");
		Assert.assertEquals(retornoImpostor.get(0).codigoVuelo,"0120");
	}
}
