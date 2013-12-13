package criteriosDeOrdenamiento.imple;

import java.util.Comparator;
import java.util.Vector;

import criterioDeOrdenamiento.CriterioDeOrdenamiento;
import domain.Asiento;

public class CriterioPrecio extends CriterioDeOrdenamiento implements Comparator
{
	private boolean sentidoAscendente;
	
	public CriterioPrecio(boolean sentidoAscendente)
	{
		super();
		this.setSentidoAscendente(sentidoAscendente);
	}

	@Override
	public int compare(Object o1, Object o2)
	{
		int resultado;
		Asiento asiento1 = (Asiento) o1;
		Asiento asiento2 = (Asiento) o2;
		
		resultado = (int) (asiento1.getPrecioTotal() - asiento2.getPrecioTotal());
		
		if(!this.getSentidoAscendente())
		{
			//Le cambio el signo
			resultado = 0 - resultado;
		}
		
		return resultado;
	}

	
	//Getters & Setters
	
	public boolean getSentidoAscendente()
	{
		return sentidoAscendente;
	}

	public void setSentidoAscendente(boolean sentidoAscendente)
	{
		this.sentidoAscendente = sentidoAscendente;
	}
}
