package decorator.filtro.imple;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.FiltroDecorator;
import domain.Asiento;
import domain.Clase;

public class FiltroClase extends FiltroDecorator
{
	private List<Clase> claseDelFiltro;


	public FiltroClase(ComponenteFiltrado componente, List<Clase> clases)
	{
		super(componente);
		this.setClaseDelFiltro(clases);
	}

	
	/*
	 * filtroClase recibe una lista de clases
	 * si la clase del asiento se encuentra en esa lista de clases,
	 * entonces agrega al asiento a "nuevaColeccion"
	 * finalmente devuelve "nuevaColeccion"
	 * 
	*/
	
	@Override
	protected Collection<Asiento> filtrar(Collection<Asiento> col)
	{	
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		String claseAsiento;
		
		for(Asiento asiento : col)	
		{
			claseAsiento = asiento.getClase().toString();
				
			if(this.contiene(claseAsiento,getClaseDelFiltro())) 
			{
				nuevaColeccion.add(asiento);
			}
		}
		
		return nuevaColeccion;
	}
	
	private boolean contiene(String claseAsiento, List<Clase> clasesDelFiltro) {
		for(Clase unaClase : clasesDelFiltro)	
		{
			if(unaClase.toString() == claseAsiento)
			{
				return true;
			}
		}
		return false;
	}


	public List<Clase> getClaseDelFiltro()
	{
		return claseDelFiltro;
	}


	public void setClaseDelFiltro(List<Clase> clases)
	{
		this.claseDelFiltro = clases;
	}
	
}
