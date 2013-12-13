package domain;

import java.util.Collection;
import java.util.Vector;

import util.fecha.Fecha;
import util.fecha.Hora;
import criterioDeOrdenamiento.Criterio;


public class Busqueda
{

	private Ciudad origen;
	private Ciudad destino;
	private Fecha fechaSalida;
	private Hora horaSalida;
	private Fecha fechaLlegada;
	private Hora horaLlegada;
	private Collection<Clase> clases;
	private Ubicacion ubicacion;
	private Integer precioMinimo;
	private Integer precioMaximo;
	private Criterio criterio;
	private Collection<Estado> estados;
	

	private Collection<Asiento> resultado = new Vector<Asiento>();
	
	public Busqueda()
	{
		
	}
	
	
	public Busqueda(Ciudad origen, Ciudad destino, Fecha fechaSalida, Hora horaSalida, Fecha fechaLlegada, Hora horaLlegada, Collection<Clase> clases, Ubicacion ubicacion, Integer precioMinimo,
			Integer precioMaximo, Criterio criterio, Collection<Estado> estados, Collection<Asiento> resultado)
	{
		super();
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.fechaLlegada = fechaLlegada;
		this.horaLlegada = horaLlegada;
		this.clases = clases;
		this.ubicacion = ubicacion;
		this.precioMinimo = precioMinimo;
		this.precioMaximo = precioMaximo;
		this.criterio = criterio;
		this.estados = estados;
		this.resultado = resultado;
	}




	//Getters & Setters

	public Collection<Asiento> getResultado()
	{
		return resultado;
	}

	public void setResultado(Collection<Asiento> resultado)
	{
		this.resultado = resultado;
	}

	public Ciudad getOrigen()
	{
		return origen;
	}

	public void setOrigen(Ciudad origen)
	{
		this.origen = origen;
	}

	public Ciudad getDestino()
	{
		return destino;
	}

	public void setDestino(Ciudad destino)
	{
		this.destino = destino;
	}

	public Fecha getFechaSalida()
	{
		return fechaSalida;
	}

	public void setFechaSalida(Fecha fechaSalida)
	{
		this.fechaSalida = fechaSalida;
	}

	public Hora getHoraSalida()
	{
		return horaSalida;
	}

	public void setHoraSalida(Hora horaSalida)
	{
		this.horaSalida = horaSalida;
	}

	public Fecha getFechaLlegada()
	{
		return fechaLlegada;
	}

	public void setFechaLlegada(Fecha fechaLlegada)
	{
		this.fechaLlegada = fechaLlegada;
	}

	public Hora getHoraLlegada()
	{
		return horaLlegada;
	}

	public void setHoraLlegada(Hora horaLlegada)
	{
		this.horaLlegada = horaLlegada;
	}

	public Collection<Clase> getClases()
	{
		return clases;
	}

	public void setClases(Collection<Clase> clases)
	{
		this.clases = clases;
	}

	public Ubicacion getUbicacion()
	{
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion)
	{
		this.ubicacion = ubicacion;
	}
	
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

	public Criterio getCriterio()
	{
		return criterio;
	}

	public void setCriterio(Criterio criterio)
	{
		this.criterio = criterio;
	}

	public Collection<Estado> getEstados()
	{
		return estados;
	}

	public void setEstados(Collection<Estado> estados)
	{
		this.estados = estados;
	}

}
