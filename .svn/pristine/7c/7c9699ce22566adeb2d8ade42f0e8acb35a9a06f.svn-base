package criteriosDeOrdenamiento.imple;

import java.util.Comparator;

import baseDeDatos.VuelosBD;
import criterioDeOrdenamiento.CriterioDeOrdenamiento;
import domain.Asiento;
import domain.Vuelo;

public class CriterioPopularidad extends CriterioDeOrdenamiento implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		int resultado;
		
		Asiento asiento1 = (Asiento) o1;
		Asiento asiento2 = (Asiento) o2;
		
		Vuelo vuelo1 = VuelosBD.obtenerVuelo(asiento1.getCodigoVuelo());
		Vuelo vuelo2 = VuelosBD.obtenerVuelo(asiento2.getCodigoVuelo());
		
		resultado = vuelo2.getPopularidad() - vuelo1.getPopularidad();
		
		return resultado;
	}

}
