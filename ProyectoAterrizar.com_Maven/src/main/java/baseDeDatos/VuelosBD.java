package baseDeDatos;

import java.util.Hashtable;

import domain.Asiento;
import domain.Vuelo;
import domain.exception.NoExisteVueloException;

public class VuelosBD
{
	private static Hashtable<String, Vuelo> vuelos = new Hashtable<String, Vuelo>();

	public static void agregarVuelo(String codigo)
	{
		boolean encontrado = vuelos.get(codigo) != null;

		if(!encontrado)
		{
			Vuelo unVuelo = new Vuelo(codigo);
			vuelos.put(codigo, unVuelo);
		}

	}

	public static Vuelo obtenerVuelo(String codigo)
	{
		Vuelo vuelo = vuelos.get(codigo);

		if(vuelo == null) throw new NoExisteVueloException();

		return vuelo;
	}

	public static void incrementarPopularidad(String codigo)
	{
		Vuelo unVuelo = obtenerVuelo(codigo);
		unVuelo.incrementarPopularidad();
	}

}
