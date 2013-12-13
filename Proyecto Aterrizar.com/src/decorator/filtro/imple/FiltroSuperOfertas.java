package decorator.filtro.imple;

import java.util.Collection;
import java.util.Vector;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.FiltroDecorator;
import domain.Asiento;

public class FiltroSuperOfertas extends FiltroDecorator
{

	public FiltroSuperOfertas(ComponenteFiltrado componente)
	{
		super(componente);
	}

	
	@Override
	protected Collection<Asiento> filtrar(Collection<Asiento> col)
	{	
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		
		for(Asiento asiento : col)	
		{		
			if(!asiento.getEsSuperOferta()) 
			{
				nuevaColeccion.add(asiento);
			}
		}
		
		return nuevaColeccion;
	}
	
}
