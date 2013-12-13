package domain;

import java.util.Collection;
import java.util.Vector;




public abstract class Usuario
{
	private String nombre;
	private String apellido;
	private int dni;
	protected double recargo;
	protected boolean puedeVerSuperOfertas;
	protected Collection<Busqueda> busquedasRealizadas = new Vector<Busqueda>();
	protected String tipoDeUsuario;

	public void agregarBusqueda(Busqueda unaBusqueda, Collection<Asiento> col)
	{
		unaBusqueda.setResultado(col);
		this.getBusquedasRealizadas().add(unaBusqueda);
	}
	
	public String toString()
	{
		return "Nombre: "+nombre+" - Apellido: "+apellido+" - DNI: "+dni+" Tipo: "+tipoDeUsuario;
	}
	
	
	
	//Getters & Setters
	
	public String getTipoDeUsuario()
	{
		return tipoDeUsuario;
	}
	public boolean getPuedeVerSuperOfertas()
	{
		return puedeVerSuperOfertas;
	}
	public double getRecargo()
	{
		return recargo;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getApellido()
	{
		return apellido;
	}
	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}
	public int getDni()
	{
		return dni;
	}
	public void setDni(int dni)
	{
		this.dni = dni;
	}
	
	public Collection<Busqueda> getBusquedasRealizadas()
	{
		return busquedasRealizadas;
	}

	public void setBusquedasRealizadas(Collection<Busqueda> busquedasRealizadas)
	{
		this.busquedasRealizadas = busquedasRealizadas;
	}

}
