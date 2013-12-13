package filtro.imple;

import java.util.Collection;

import domain.Asiento;
import domain.Clase;
import filtro.ComponenteFiltrado;
import filtro.FiltroDecorator;

public class FiltroClase extends FiltroDecorator
{
	private Collection<Clase> clasesDelFiltro;

	public FiltroClase(ComponenteFiltrado componente, Collection<Clase> clases)
	{
		super(componente);
		this.setClasesDelFiltro(clases);
	}

	@Override
	protected boolean aprueba(Asiento asiento)
	{
		boolean resultado;

		if(this.getClasesDelFiltro() != null)
		{
			String claseActual = asiento.getClase().toString();

			for(Clase unaClase : this.getClasesDelFiltro())
			{
				String strClaseRequerida = unaClase.toString();
				if(claseActual.equals(strClaseRequerida))
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

	// Getters & Setters

	public Collection<Clase> getClasesDelFiltro()
	{
		return clasesDelFiltro;
	}

	public void setClasesDelFiltro(Collection<Clase> clasesDelFiltro)
	{
		this.clasesDelFiltro = clasesDelFiltro;
	}

}
