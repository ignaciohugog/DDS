package decorator.filtro.imple;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.FiltroDecorator;
import domain.Asiento;

public class FiltroPrecio extends FiltroDecorator
{
	
	private Integer precioMinimo;
	private Integer precioMaximo;
	
	public FiltroPrecio(ComponenteFiltrado componente, Integer precioMinimo, Integer precioMaximo)
	{
		super(componente);
		this.setPrecioMinimo(precioMinimo);
		this.setPrecioMaximo(precioMaximo);
	}

	@Override
	protected boolean aprueba(Asiento asiento)
	{
		boolean condicionPrecioMinimo;
		boolean condicionPrecioMaximo;
		
		if(this.getPrecioMinimo() != null)
		{
			if(asiento.getPrecioTotal() >= this.getPrecioMinimo())
			{
				condicionPrecioMinimo = true;
			}
			else 
			{
				condicionPrecioMinimo = false;
			}
		}
		else
		{
			condicionPrecioMinimo = true;
		}
		
		
		if(this.getPrecioMaximo() != null)
		{
			if(asiento.getPrecioTotal() <= this.getPrecioMaximo())
			{
				condicionPrecioMaximo = true;
			}
			else
			{
				condicionPrecioMaximo = false;
			}
		}
		else
		{
			condicionPrecioMaximo = true;
		}
		
		
		return condicionPrecioMinimo && condicionPrecioMaximo;
	}
	
	
	//Getters & Setters
	
	public Integer getPrecioMinimo()
	{
		return precioMinimo;
	}

	public void setPrecioMinimo(Integer precioMinimo)
	{
		this.precioMinimo = precioMinimo;
	}

	public Integer getPrecioMaximo()
	{
		return precioMaximo;
	}

	public void setPrecioMaximo(Integer precioMaximo)
	{
		this.precioMaximo = precioMaximo;
	}




}
