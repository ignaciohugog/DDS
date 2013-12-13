package decorator.filtro.imple;

import java.util.Collection;
import java.util.Vector;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.FiltroDecorator;
import domain.Asiento;
import domain.Ubicacion;

public class FiltroUbicacion extends FiltroDecorator
{
	private Ubicacion ubicacionFiltro;


	public FiltroUbicacion(ComponenteFiltrado componente, Ubicacion ubicacion)
	{
		super(componente);
		this.setUbicacionFiltro(ubicacion);
	}

	
	@Override
	protected Collection<Asiento> filtrar(Collection<Asiento> col)
	{	
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		String ubicacionFiltro = this.getUbicacionFiltro().toString();
		String ubicacionAsiento;
		
		for(Asiento asiento : col)	
		{
			ubicacionAsiento = asiento.getUbicacion().toString();
				
			if(ubicacionAsiento.equals(ubicacionFiltro)) 
			{
				nuevaColeccion.add(asiento);
			}
		}
		
		return nuevaColeccion;
	}
	
	public Ubicacion getUbicacionFiltro()
	{
		return ubicacionFiltro;
	}


	public void setUbicacionFiltro(Ubicacion ubicacionFiltro)
	{
		this.ubicacionFiltro = ubicacionFiltro;
	}
	
}
