package domain;

public class Ciudad
{
	public String ciudad;

	public Ciudad(String nombre)
	{
		this.setCiudad(nombre);
	}

	public String toString()
	{
		return ciudad;
	}

	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
	}

}
