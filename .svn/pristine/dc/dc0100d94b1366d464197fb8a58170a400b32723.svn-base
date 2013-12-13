package filtro.imple;

import domain.Asiento;
import filtro.ComponenteFiltrado;
import filtro.FiltroDecorator;

public class FiltroSuperOfertas extends FiltroDecorator
{

	private boolean puedeVerSuperOfertas;

	public FiltroSuperOfertas(ComponenteFiltrado componente, boolean puedeVerSuperOfertas)
	{
		super(componente);
		this.setPuedeVerSuperOfertas(puedeVerSuperOfertas);
	}

	@Override
	protected boolean aprueba(Asiento asiento)
	{
		boolean resultado;

		if(puedeVerSuperOfertas)
		{
			resultado = true;
		}
		else
		{
			resultado = !asiento.getEsSuperOferta();
		}

		return resultado;
	}

	// Getters & Setters

	public boolean getPuedeVerSuperOfertas()
	{
		return puedeVerSuperOfertas;
	}

	public void setPuedeVerSuperOfertas(boolean puedeVerSuperOfertas)
	{
		this.puedeVerSuperOfertas = puedeVerSuperOfertas;
	}

}
