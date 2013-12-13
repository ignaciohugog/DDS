package app.test;

import java.util.Collection;

import util.UFactory;
import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;
import app.Aterrizar;
import criterioDeOrdenamiento.Criterio;
import criteriosDeOrdenamiento.imple.CriterioPrecio;
import criteriosDeOrdenamiento.imple.SinCriterio;
import domain.Asiento;
import domain.Busqueda;
import domain.Ciudad;
import domain.Clase;
import domain.Ubicacion;
import domain.Usuario;

public class Cliente
{
	public static Usuario user;
	
	
	public static void main(String[] args)
	{
		Aterrizar facade = (Aterrizar) UFactory.getInstancia("ATERRIZAR");
		
		
		//Autentifico el usuario
		user = facade.autenticar("Pepe", "Gonzalez", 12345678);

		_mostrarDatosUsuario();
		
		
		Ciudad buenosAires = new Ciudad("Buenos Aires");
		Ciudad losAngeles = new Ciudad("Los Angeles");
		Fecha fechaSalida = UFecha.convertirAFecha("15/08/2012");
		Hora horaSalida = UFecha.convertirAHora("15:35");
		Fecha fechaLlegada = UFecha.convertirAFecha("17/08/2012");
		Hora horaLlegada = UFecha.convertirAHora("17:35");
		Collection<Clase> clase = null;
		Ubicacion ubicacion = null;
		Integer precioMinimo = null;
		Integer precioMaximo = null;
		Criterio criterio = new CriterioPrecio(false);
		

		Busqueda busqueda = new Busqueda(buenosAires, losAngeles, fechaSalida, horaSalida, fechaLlegada, horaLlegada, clase, ubicacion, precioMinimo, precioMaximo, criterio, null, null);

		//Busqueda busqueda = new Busqueda(buenosAires, losAngeles, fechaSalida, horaSalida, fechaLlegada, horaLlegada, clase, ubicacion);	
		
		
		Collection<Asiento> col = facade.obtenerAsientosDisponibles(busqueda, user);
		
		//Verifico que la coleccion no este vacia
		if(col.isEmpty()) System.out.println("Vacia");
		
		_mostrarAsientosDisponibles(col);
		
		
		
		
		//Prueba Comprar
		
		//Asiento asiento = _obtenerAsiento("01202022220202", 3, col);
		//System.out.println("ASIENTO:\n"+asiento);
		//facade.comprarAsiento(asiento, user);
		
		//col = facade.obtenerAsientosDisponibles(user, buenosAires, losAngeles, fechaSalida, horaSalida, fechaLlegada, horaLlegada, clase, ubicacion, false);
		//_mostrarAsientosDisponibles(col);	
		
	}
	
	public static void _mostrarAsientosDisponibles(Collection<Asiento> col)
	{
		int i = 1;
		
		System.out.println("-[ASIENTOS DISPONIBLES]-\n");
		for(Asiento dto : col)
		{
			System.out.println(i);
			System.out.println(dto);
			
			i++;
		}
	}
	
	
	public static void _mostrarDatosUsuario()
	{
		System.out.println("-[USUARIO]-");
		System.out.println(user);
		System.out.println("Recargo: $"+user.getRecargo());
		System.out.print("\n");
	}
	
	public static Asiento _obtenerAsiento(String codigoDeVuelo, int numeroDeAsiento, Collection<Asiento> col)
	{
		Asiento a = null;
		
		for(Asiento asiento : col)
		{
			if((asiento.getCodigoVuelo().equals(codigoDeVuelo)) && (asiento.getNumeroAsiento() == numeroDeAsiento))
			{
				a = asiento;
			}
		}
		
		return a;
	}
	
	
	
}
