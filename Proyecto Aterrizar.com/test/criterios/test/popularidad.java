package criterios.test;


	
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
import criterioDeOrdenamiento.CriterioPopularidad;
import junit.framework.Assert;
import org.junit.Before;
	import org.junit.Test;
import domain.Asiento;
	import domain.Vuelo;
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

	public class popularidad {
		protected List<Asiento>retornoImpostor = new ArrayList<Asiento>();
		
		AerolineaLanchitaImple lanchitaImple = new AerolineaLanchitaImple();
	
		
		
		@Before
		public void setUp() {
			Fecha unaFecha = new Fecha();
			Hora unaHora = new Hora();
			

			
			Asiento unAsiento = new Asiento(lanchitaImple, "0202", 3,
					unaFecha, unaFecha, unaHora, unaHora, 159.90, 0, 
					new PrimeraClase(), new UbicacionVentana(), new EstadoDisponible());
			unAsiento.setVuelo(new Vuelo("AR345", "BUE", "LA", unaFecha, unaFecha));
			unAsiento.getVuelo().setPopularidad(3);
			retornoImpostor.add(unAsiento);
			
			
			Asiento unAsiento1 = new Asiento(lanchitaImple, "03434", 67,
					unaFecha, unaFecha, unaHora, unaHora, 159.90, 877, 
					new PrimeraClase(), new UbicacionCentro(), new EstadoComprado());
			unAsiento1.setVuelo(new Vuelo("BR222", "BRA", "GR", unaFecha, unaFecha));
			unAsiento1.getVuelo().setPopularidad(15);
			retornoImpostor.add(unAsiento1);
			
			Asiento unAsiento11 = new Asiento(lanchitaImple, "043", 345,
					unaFecha, unaFecha, unaHora, unaHora, 13454.9, 333332, 
					new ClaseEjecutiva(), new UbicacionPasillo(), new EstadoReservado());
			unAsiento11.setVuelo(new Vuelo("PL666", "GRA", "USA", unaFecha, unaFecha));
			unAsiento11.getVuelo().setPopularidad(30);
			retornoImpostor.add(unAsiento11);
			
			Asiento unAsiento111 = new Asiento(lanchitaImple, "0120", 3,
					unaFecha, unaFecha, unaHora, unaHora, 159.90, 0, 
					new ClaseTurista(), new UbicacionCentro(), new EstadoComprado());
			unAsiento111.setVuelo(new Vuelo("SZ999", "ESP", "CAN", unaFecha, unaFecha));
			unAsiento111.getVuelo().setPopularidad(1);
			retornoImpostor.add(unAsiento111);
		}
		
		@Test
		public void ordenoUnaListaPorPopularidadAscendente(){
			CriterioPopularidad unCriterio = new CriterioPopularidad();
			unCriterio.setAscendente(true);
			Collections.sort(retornoImpostor,unCriterio);
			Assert.assertEquals(retornoImpostor.get(0).codigoVuelo,"0120");
			Assert.assertEquals(retornoImpostor.get(1).codigoVuelo,"0202");
			Assert.assertEquals(retornoImpostor.get(2).codigoVuelo,"03434");
			Assert.assertEquals(retornoImpostor.get(3).codigoVuelo,"043");
		}

		@Test
		public void ordenoUnaListaPorPopularidadDescendente(){
			CriterioPopularidad unCriterio = new CriterioPopularidad();
			unCriterio.setAscendente(false);
			Collections.sort(retornoImpostor,unCriterio);
			Assert.assertEquals(retornoImpostor.get(3).codigoVuelo,"0120");
			Assert.assertEquals(retornoImpostor.get(2).codigoVuelo,"0202");
			Assert.assertEquals(retornoImpostor.get(1).codigoVuelo,"03434");
			Assert.assertEquals(retornoImpostor.get(0).codigoVuelo,"043");
		}
	}



