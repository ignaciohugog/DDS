package domain;

import java.util.Date;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asiento
{
	private Aerolinea aerolinea;
	private String codigoVuelo;
	private int numeroAsiento;
	private Date fechaSalida;
	private Date fechaLlegada;
	private Date horaSalida;
	private Date horaLlegada;
	private double precio;
	private double precioTotal;
	private Clase clase;
	private Ubicacion ubicacion;
	private Estado estado;
	private boolean reservado;

	public Asiento()
	{

	}

	public Asiento(Aerolinea aerolinea, String codigoVuelo, int numeroAsiento, Date fechaSalida, Date fechaLlegada, Date horaSalida, Date horaLlegada, double precio, double precioTotal, Clase clase,
			Ubicacion ubicacion, Estado estado)
	{
		this.aerolinea = aerolinea;
		this.codigoVuelo = codigoVuelo;
		this.numeroAsiento = numeroAsiento;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.precio = precio;
		this.precioTotal = precioTotal;
		this.clase = clase;
		this.ubicacion = ubicacion;
		this.estado = estado;
	}

	public String toString()
	{

		return "Aerolinea: " + this.getAerolinea().getNombre() + " - Vuelo: " + this.getCodigoVuelo() + " - Asiento: " + this.getNumeroAsiento() + "\nPrecio: " + this.getPrecio() + " - PrecioTotal: "
				+ this.getPrecioTotal() + "\nFecha Salida: " + this.getFechaSalida() + " - Hora Salida: " + this.getHoraSalida() + " - Fecha Llegada: " + this.getFechaLlegada() + " - Hora Llegada: "
				+ this.getHoraLlegada() + "\nClase: " + this.getClase() + " - Ubicacion: " + this.getUbicacion() + " - Estado: " + this.getEstado() + "\n";
	}

	// Getters & Setters
	public Estado getEstado()
	{
		return estado;
	}

	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}

	public Date getFechaSalida()
	{
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida)
	{
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLlegada()
	{
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada)
	{
		this.fechaLlegada = fechaLlegada;
	}

	public Date getHoraSalida()
	{
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida)
	{
		this.horaSalida = horaSalida;
	}

	public Date getHoraLlegada()
	{
		return horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada)
	{
		this.horaLlegada = horaLlegada;
	}

	public boolean getEsSuperOferta()
	{
		return clase.esSuperOferta(precioTotal);
	}

	public double getPrecioTotal()
	{
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal)
	{
		this.precioTotal = precioTotal;
	}

	public Aerolinea getAerolinea()
	{
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea)
	{
		this.aerolinea = aerolinea;
	}

	public String getCodigoVuelo()
	{
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo)
	{
		this.codigoVuelo = codigoVuelo;
	}

	public int getNumeroAsiento()
	{
		return numeroAsiento;
	}

	public void setNumeroAsiento(int numeroAsiento)
	{
		this.numeroAsiento = numeroAsiento;
	}

	public double getPrecio()
	{
		return precio;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
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

	public boolean getReservado()
	{
		return reservado;
	}

	public void setReservado(boolean reservado)
	{
		this.reservado = reservado;
	}

}
