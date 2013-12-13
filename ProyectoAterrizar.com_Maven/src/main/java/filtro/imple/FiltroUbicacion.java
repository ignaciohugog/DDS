package filtro.imple;

import domain.Asiento;
import domain.Ubicacion;
import filtro.ComponenteFiltrado;
import filtro.FiltroDecorator;

public class FiltroUbicacion extends FiltroDecorator
{
	private Ubicacion ubicacionFiltro;

	public FiltroUbicacion(ComponenteFiltrado componente, Ubicacion ubicacion)
	{
		super(componente);
		this.setUbicacionFiltro(ubicacion);
	}

	@Override
	protected boolean aprueba(Asiento asiento)
	{
		boolean resultado;

		if(this.getUbicacionFiltro() != null)
		{
			String strUbicacionRequerida = this.getUbicacionFiltro().toString();
			String ubicacionActual = asiento.getUbicacion().toString();
			resultado = ubicacionActual.equals(strUbicacionRequerida);
		}
		else
		{
			resultado = true;
		}

		return resultado;
	}

	// Getters & Setters

	public Ubicacion getUbicacionFiltro()
	{
		return ubicacionFiltro;
	}

	public void setUbicacionFiltro(Ubicacion ubicacionFiltro)
	{
		this.ubicacionFiltro = ubicacionFiltro;
	}

}
