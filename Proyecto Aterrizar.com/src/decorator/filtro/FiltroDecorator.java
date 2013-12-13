package decorator.filtro;

import java.util.Collection;
import java.util.Vector;

import domain.Asiento;

public abstract class FiltroDecorator implements ComponenteFiltrado
{
	private ComponenteFiltrado siguiente;
	
	
	public FiltroDecorator(ComponenteFiltrado componente)
	{
		this.setSiguiente(componente);
	}

	
	public Collection<Asiento> operar()
	{
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		Collection<Asiento> col = this.getSiguiente().operar();
		
		nuevaColeccion = this.filtrar(col);
		
		return nuevaColeccion;
	}
	
	
	protected abstract Collection<Asiento> filtrar(Collection<Asiento> col);

	
	
	public ComponenteFiltrado getSiguiente()
	{
		return siguiente;
	}

	public void setSiguiente(ComponenteFiltrado siguiente)
	{
		this.siguiente = siguiente;
	}

}
