package decorator.filtro.imple;

import java.util.Collection;
import java.util.Vector;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.FiltroDecorator;
import domain.Asiento;

public class FiltroReservados extends FiltroDecorator
{

	public FiltroReservados(ComponenteFiltrado componente)
	{
		super(componente);
	}

	
	@Override
	protected Collection<Asiento> filtrar(Collection<Asiento> col)
	{	
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		
		for(Asiento asiento : col)	
		{		
			if(!asiento.getReservado()) 
			{
				nuevaColeccion.add(asiento);
			}
		}
		
		return nuevaColeccion;
	}
	
}