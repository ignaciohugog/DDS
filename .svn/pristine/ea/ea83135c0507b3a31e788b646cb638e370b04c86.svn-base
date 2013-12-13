package domain.aerolinea.imple;

import java.util.Collection;
import java.util.Vector;

import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;

import baseDeDatos.VuelosBD;

import com.lanchita.AerolineaLanchita;

import domain.Aerolinea;
import domain.Asiento;
import domain.Busqueda;
import domain.Usuario;
import domain.asiento.clase.ClaseEjecutiva;
import domain.asiento.clase.ClaseTurista;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.estado.EstadoComprado;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.estado.EstadoReservado;
import domain.asiento.ubicacion.UbicacionCentro;
import domain.asiento.ubicacion.UbicacionPasillo;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.exception.AsientoNoDisponibleException;

public class AerolineaLanchitaImple extends Aerolinea<AerolineaLanchita>
{

	// Constructor
	public AerolineaLanchitaImple()
	{
		this.setInstancia(AerolineaLanchita.getInstance());
		this.setNombre("Lanchita");
		this.setImpuesto(0.15);
	}

	@Override
	public Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario)
	{
		Collection<Asiento> col;

		// Inicializo
		String strOrigen = this.parsearNombreDeCiudad(busqueda.getOrigen().toString());
		String strDestino = this.parsearNombreDeCiudad(busqueda.getDestino().toString());
		String strFechaSalida = busqueda.getFechaSalida().toString();
		String strHoraSalida = busqueda.getHoraSalida().toString();
		String strFechaLlegada = busqueda.getFechaLlegada().toString();
		String strHoraLlegada = busqueda.getHoraLlegada().toString();

		String[][] arrAsientos = this.getInstancia().asientosDisponibles(strOrigen, strDestino, strFechaSalida, strHoraSalida, strFechaLlegada, strHoraLlegada);

		col = this.generarColeccionDeAsientos(arrAsientos, usuario);

		return col;
	}

	private Collection<Asiento> generarColeccionDeAsientos(String[][] arrAsientos, Usuario usuario)
	{
		/*
		 * Campos de un asiento 0:Codigo de vuelo y nro asiento 1:Precio
		 * definido por aerolinea 2:Clase 3:Ubicacion 4:Estado 5:Indefinido
		 * 6:Hora salida 7:HoraLlegada 8:Origen 9:Destino 10:Fecha salida
		 * 11:Fecha llegada
		 */

		Asiento dto;
		String[] unAsiento;
		Collection<Asiento> col = new Vector<Asiento>();

		for(int i = 0; i < arrAsientos.length; i++)
		{
			dto = new Asiento();
			unAsiento = arrAsientos[i];

			dto.setAerolinea(this);
			this.establecerCodigos(unAsiento[0], dto);
			this.establecerPrecios(unAsiento[1], dto, usuario);
			this.establecerFechasYHorarios(unAsiento[10], unAsiento[6], unAsiento[11], unAsiento[7], dto);
			this.establecerClase(unAsiento[2], dto);
			this.establecerUbicacion(unAsiento[3], dto);
			this.establecerEstado(unAsiento[4], dto);
			this.establecerVuelo(unAsiento[0]);
			
			col.add(dto);
		}

		return col;

	}

	public String parsearNombreDeCiudad(String ciudad)
	{
		// Por ahora no hace nada
		return ciudad;
	}

	private void establecerCodigos(String strCodigo, Asiento dto)
	{
		int pos;
		String codVuelo;
		int numeroAsiento;

		pos = strCodigo.indexOf('-');
		codVuelo = strCodigo.substring(0, pos);
		numeroAsiento = Integer.parseInt(strCodigo.substring(pos + 1));

		dto.setCodigoVuelo(codVuelo);
		dto.setNumeroAsiento(numeroAsiento);
	}

	private void establecerPrecios(String strPrecio, Asiento dto, Usuario usuario)
	{
		double precio;
		double precioTotal;

		precio = Double.parseDouble(strPrecio);
		precioTotal = this.getPrecioTotal(precio, usuario);

		dto.setPrecio(precio);
		dto.setPrecioTotal(precioTotal);
	}

	private void establecerFechasYHorarios(String fechaSalida, String horaSalida, String fechaLlegada, String horaLlegada, Asiento dto)
	{
		Fecha fSalida = UFecha.convertirAFecha(fechaSalida);
		Fecha fLlegada = UFecha.convertirAFecha(fechaLlegada);
		Hora hSalida = UFecha.convertirAHora(horaSalida);
		Hora hLlegada = UFecha.convertirAHora(horaLlegada);

		dto.setFechaSalida(fSalida);
		dto.setFechaLlegada(fLlegada);
		dto.setHoraSalida(hSalida);
		dto.setHoraLlegada(hLlegada);
	}

	private void establecerClase(String clase, Asiento dto)
	{
		switch(clase.charAt(0))
		{
			case 'P':
				dto.setClase(new PrimeraClase());
				break;
			case 'E':
				dto.setClase(new ClaseEjecutiva());
				break;
			default:
				dto.setClase(new ClaseTurista());
				break;
		}

	}

	private void establecerUbicacion(String ubicacion, Asiento dto)
	{
		switch(ubicacion.charAt(0))
		{
			case 'P':
				dto.setUbicacion(new UbicacionPasillo());
				break;
			case 'C':
				dto.setUbicacion(new UbicacionCentro());
				break;
			default:
				dto.setUbicacion(new UbicacionVentana());
				break;
		}

	}

	private void establecerEstado(String estado, Asiento dto)
	{
		switch(estado.charAt(0))
		{
			case 'D':
				dto.setEstado(new EstadoDisponible());
				break;
			case 'R':
				dto.setEstado(new EstadoReservado());
				break;
			default:
				dto.setEstado(new EstadoComprado());
				break;
		}
	}
	
	
	private void establecerVuelo(String codigo)
	{
		int pos;
		String codVuelo;

		pos = codigo.indexOf('-');
		codVuelo = codigo.substring(0, pos);
		VuelosBD.agregarVuelo(codVuelo);
	}
	

	@Override
	public void comprarAsiento(Asiento asiento, Usuario usuario)
	{
		String codigoVuelo = asiento.getCodigoVuelo();
		int numeroAsiento = asiento.getNumeroAsiento();
		String codigo = codigoVuelo + "-" + String.valueOf(numeroAsiento);

		try
		{
			this.getInstancia().comprar(codigo);
		}
		catch(Exception ex)
		{
			throw new AsientoNoDisponibleException(ex, codigoVuelo, numeroAsiento);
		}

	}

	@Override
	public void reservarAsiento(Asiento asiento, Usuario usuario)
	{
		String codigoVuelo = asiento.getCodigoVuelo();
		int numeroAsiento = asiento.getNumeroAsiento();

		String codigo = codigoVuelo + "-" + String.valueOf(numeroAsiento);
		String dni = String.valueOf(usuario.getDni());

		try
		{
			this.getInstancia().reservar(codigo, dni);
		}
		catch(Exception ex)
		{
			throw new AsientoNoDisponibleException(ex, codigoVuelo, numeroAsiento);
		}
	}

}
