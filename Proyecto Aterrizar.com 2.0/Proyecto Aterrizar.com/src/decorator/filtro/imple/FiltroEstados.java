package decorator.filtro.imple;

import java.util.Collection;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.FiltroDecorator;
import domain.Asiento;
import domain.Clase;
import domain.Estado;

public class FiltroEstados extends FiltroDecorator
{

	private Collection<Estado> estados;
	
	public FiltroEstados(ComponenteFiltrado componente, Collection<Estado> estados)
	{
		super(componente);
		this.setEstados(estados);
	}

	@Override
	protected boolean aprueba(Asiento asiento)
	{
	boolean resultado;
		
		if(this.getEstados()!= null)
		{
			String estadoActual = asiento.getEstado().getNombre();
			
			for(Estado unEstado : this.getEstados())
			{
				String strEstadoRequerido = unEstado.getNombre();
				if(estadoActual.equals(strEstadoRequerido))
				{
					return true;
				}
			}
			
			resultado = false;
		}
		else
		{
			resultado = true;
		}
		
		return resultado;
	}

	
	//Getters & Setters
	
	public Collection<Estado> getEstados()
	{
		return estados;
	}

	public void setEstados(Collection<Estado> estados)
	{
		this.estados = estados;
	}


}
