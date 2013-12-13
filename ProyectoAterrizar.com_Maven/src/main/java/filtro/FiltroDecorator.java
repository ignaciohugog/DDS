package filtro;

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

	protected Collection<Asiento> filtrar(Collection<Asiento> col)
	{
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();

		for(Asiento asiento : col)
		{
			if(this.aprueba(asiento))
			{
				nuevaColeccion.add(asiento);
			}
		}

		return nuevaColeccion;
	}

	protected abstract boolean aprueba(Asiento asiento);

	// Getters & Setters

	public ComponenteFiltrado getSiguiente()
	{
		return siguiente;
	}

	public void setSiguiente(ComponenteFiltrado siguiente)
	{
		this.siguiente = siguiente;
	}

}
