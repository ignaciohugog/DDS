package decorator.filtro.imple;

import java.util.Collection;

import decorator.filtro.ComponenteFiltrado;
import domain.Asiento;

public class SinFiltro implements ComponenteFiltrado
{	
	
	private Collection<Asiento> coleccionDeAsiento;
	
	
	public SinFiltro(Collection<Asiento> coleccionDeAsiento)
	{
		this.setColeccionDeAsiento(coleccionDeAsiento);
	}

	@Override
	public Collection<Asiento> operar()
	{
		return this.getColeccionDeAsiento();
	}
	
	
	
	public Collection<Asiento> getColeccionDeAsiento()
	{
		return coleccionDeAsiento;
	}


	public void setColeccionDeAsiento(Collection<Asiento> coleccionDeAsiento)
	{
		this.coleccionDeAsiento = coleccionDeAsiento;
	}
	 
}
