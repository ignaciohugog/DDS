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
	private Collection<Asiento> asientosComprados = new Vector<Asiento>();
	private Collection<Asiento> asientosReservados = new Vector<Asiento>();

	public void agregarBusqueda(Busqueda unaBusqueda, Collection<Asiento> col)
	{
		unaBusqueda.setResultado(col);
		this.getBusquedasRealizadas().add(unaBusqueda);
	}
	
	public void agregarAsientoComprado(Asiento asiento)
	{
		this.getAsientosComprados().add(asiento);
	}
	
	public void agregarAsientoReservado(Asiento asiento)
	{
		this.getAsientosReservados().add(asiento);
	}

	public String toString()
	{
		return nombre + " " + apellido;
	}

	public boolean igualA(Usuario unUsuario)
	{	
		boolean resultado;
		boolean mismoNombre;
		boolean mismoApellido;
		boolean mismoDNI;
		
		mismoNombre = this.getNombre().equals(unUsuario.getNombre());
		mismoApellido = this.getApellido().equals(unUsuario.getApellido());
		mismoDNI = this.getDni() == unUsuario.getDni();
		
		resultado = mismoNombre & mismoApellido & mismoDNI;
		
		return resultado;
	}
	
	// Getters & Setters

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

	public Collection<Asiento> getAsientosComprados()
	{
		return asientosComprados;
	}

	public void setAsientosComprados(Collection<Asiento> asientosComprados)
	{
		this.asientosComprados = asientosComprados;
	}

	public Collection<Asiento> getAsientosReservados()
	{
		return asientosReservados;
	}

	public void setAsientosReservados(Collection<Asiento> asientosReservados)
	{
		this.asientosReservados = asientosReservados;
	}

	
}
