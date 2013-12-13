package domain;

public abstract class Clase
{
	public String nombreClase;

	public abstract boolean esSuperOferta(double precio);

	public String toString()
	{
		return nombreClase;
	}

	public String getNombreClase()
	{
		return nombreClase;
	}

	public void setNombreClase(String clase)
	{
		this.nombreClase = clase;
	}

}
