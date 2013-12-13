package domain;

import java.util.Collection;
import java.util.Vector;

import criterioDeOrdenamiento.CriterioDeOrdenamiento;

import util.fecha.Fecha;
import util.fecha.Hora;


public class Busqueda
{
	private Ciudad origen;
	private Ciudad destino;
	private Fecha fechaSalida;
	private Hora horaSalida;
	private Fecha fechaLlegada;
	private Hora horaLlegada;
	private Clase clase;
	private Ubicacion ubicacion;
	private double precioMin;
	private double precioMax;
	private boolean incluirReservados;
    private CriterioDeOrdenamiento criterio;
	private Collection<Asiento> resultado = new Vector<Asiento>();
	

	
	public Busqueda(Ciudad origen, Ciudad destino, Fecha fechaSalida, Hora horaSalida, Fecha fechaLlegada, Hora horaLlegada, 
			Clase clase, Ubicacion ubicacion, double precioMin, double precioMax, boolean incluirReservados)
	{	
		//Guardo los parametros de la busqueda
		
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setFechaSalida(fechaSalida);
		this.setHoraSalida(horaSalida);
		this.setFechaLlegada(fechaLlegada);
		this.setHoraLlegada(horaLlegada);
		
		this.setClase(clase);
		this.setUbicacion(ubicacion);
		this.setPrecioMin(precioMin);
		this.setPrecioMax(precioMax);
		this.setIncluirReservados(incluirReservados);
	}
	
	
	
	
	
	//Getters & Setters

	public double getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(double precioMin) {
		this.precioMin = precioMin;
	}

	public double getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(double precioMax) {
		this.precioMax = precioMax;
	}

	public boolean isIncluirReservados() {
		return incluirReservados;
	}

	public void setIncluirReservados(boolean incluirReservados) {
		this.incluirReservados = incluirReservados;
	}

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

	public Clase getClase()
	{
		return clase;
	}

	public void setClase(Clase clase)
	{
		this.clase = clase;
	}

	public Ubicacion getUbicacion()
	{
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion)
	{
		this.ubicacion = ubicacion;
	}


	
}
