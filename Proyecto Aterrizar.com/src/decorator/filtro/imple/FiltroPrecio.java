package decorator.filtro.imple;

import java.util.Collection;
import java.util.Vector;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.FiltroDecorator;
import domain.Asiento;

public class FiltroPrecio extends FiltroDecorator
{

	private double precioMin;
	private double precioMax;
	
	public FiltroPrecio(ComponenteFiltrado componente, double pMin, double pMax)
	{
		super(componente);
		this.setPrecioMin(pMin);
		this.setPrecioMax(pMax);
	}

	
	@Override
	protected Collection<Asiento> filtrar(Collection<Asiento> col)
	{	
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		
		for(Asiento asiento : col)	
		{		
			if(asiento.getPrecioTotal() >= this.getPrecioMin() && asiento.getPrecioTotal() <= this.getPrecioMax()) 
			{
				nuevaColeccion.add(asiento);
			}
		}
		
		return nuevaColeccion;
	}


	public double getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(double precioMin) {
		this.precioMin = precioMin;
	}

	public double getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(double precioMax) {
		this.precioMax = precioMax;
	}
	
}