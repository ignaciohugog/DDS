package domain;

import java.util.Collection;
import java.util.Vector;

public class Vuelo
{
	private String codigo;
	private Collection<Asiento> asientos;
	private Integer popularidad;

	public Vuelo(String unCodigo)
	{
		codigo = unCodigo;
		asientos = new Vector<Asiento>();
		popularidad = 0;
	}

	public void agregarAsiento(Asiento unAsiento)
	{
		asientos.add(unAsiento);
	}

	public void incrementarPopularidad()
	{
		popularidad++;
	}

	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public Collection<Asiento> getAsientos()
	{
		return asientos;
	}

	public void setAsientos(Collection<Asiento> asientos)
	{
		this.asientos = asientos;
	}

	public Integer getPopularidad()
	{
		return popularidad;
	}

	public void setPopularidad(Integer popularidad)
	{
		this.popularidad = popularidad;
	}

}
