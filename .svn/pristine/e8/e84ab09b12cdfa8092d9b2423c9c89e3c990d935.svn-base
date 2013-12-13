package domain.aerolinea.imple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import util.UFecha;

import baseDeDatos.VuelosBD;

import com.oceanic.AerolineaOceanic;
import com.oceanic.AsientoDTO;

import domain.Aerolinea;
import domain.Asiento;
import domain.Busqueda;
import domain.Usuario;
import domain.asiento.clase.ClaseEjecutiva;
import domain.asiento.clase.ClaseTurista;
import domain.asiento.clase.PrimeraClase;
import domain.asiento.estado.EstadoDisponible;
import domain.asiento.estado.EstadoReservado;
import domain.asiento.ubicacion.UbicacionCentro;
import domain.asiento.ubicacion.UbicacionPasillo;
import domain.asiento.ubicacion.UbicacionVentana;
import domain.exception.AsientoNoDisponibleException;

public class AerolineaOceanicImple extends Aerolinea<AerolineaOceanic>
{
	// Constructor
	public AerolineaOceanicImple()
	{
		this.setInstancia(AerolineaOceanic.getInstance());
		this.setNombre("Oceanic");
		this.setImpuesto(0);
	}

	@Override
	public Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario)
	{
		// Inicializo
		String strOrigen = this.parsearNombreDeCiudad(busqueda.getOrigen().toString());
		String strDestino = this.parsearNombreDeCiudad(busqueda.getDestino().toString());
		String strFechaSalida = busqueda.getFechaSalida().toString();
		String strHoraSalida = null;
		
		if (busqueda.getHoraSalida()!= null) strHoraSalida = busqueda.getHoraSalida().toString();
		String strFechaLlegada = null;
		if(busqueda.getFechaLlegada()!= null) strFechaLlegada = busqueda.getFechaLlegada().toString();
		String strHoraLlegada = null;
		if (busqueda.getHoraLlegada()!= null) strHoraLlegada = busqueda.getHoraLlegada().toString();
		
		Collection<AsientoDTO> col = new ArrayList<AsientoDTO>();
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();

		col = obtenerAsientosDTO(strOrigen, strDestino, strFechaSalida, strHoraSalida, strFechaLlegada, strHoraLlegada, usuario);
		nuevaColeccion = generarColeccionDeAsientos(usuario, col);

		return nuevaColeccion;
	}

	public String parsearNombreDeCiudad(String ciudad)
	{
		String nuevoNombre = "No encontrado";
	
		if(ciudad.toString().equals("Los Angeles"))
		{
			nuevoNombre = "SLA";
		}
		if(ciudad.toString().equals("Buenos Aires"))
		{
			nuevoNombre = "_BS";
		}
		if(ciudad.toString().equals("Nueva York"))
		{
			nuevoNombre = "_NY";
		}

		return nuevoNombre;
	}

	private Collection<AsientoDTO> obtenerAsientosDTO(String origen, String destino, String fechaSalida, String horaSalida, String fechaLlegada, String horaLlegada, Usuario usuario)
	{
		Collection<AsientoDTO> col = new ArrayList<AsientoDTO>();

		if(destino == null)
		{
			col = this.getInstancia().asientosDisponiblesParaOrigen(origen, fechaSalida);
		}
		else
		{
			col = this.getInstancia().asientosDisponiblesParaOrigenYDestino(origen, destino, fechaSalida);
		}

		return col;
	}

	private Collection<Asiento> generarColeccionDeAsientos(Usuario usuario, Collection<AsientoDTO> col)
	{
		Asiento asiento;
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();

		for(AsientoDTO dto : col)
		{
			asiento = new Asiento();

			asiento.setAerolinea(this);
			asiento.setCodigoVuelo(dto.getCodigoDeVuelo());
			asiento.setNumeroAsiento(dto.getNumeroDeAsiento());
			this.establecerPrecios(dto.getPrecio(), usuario, asiento);
			this.establecerFechasYHorarios(dto, asiento);
			this.establecerClase(dto.getClase(), asiento);
			this.establecerUbicacion(dto.getUbicacion(), asiento);
			this.establecerEstado(dto.getReservado(), asiento);
			this.establecerVuelo(dto.getCodigoDeVuelo());

			nuevaColeccion.add(asiento);
		}

		return nuevaColeccion;
	}

	private void establecerPrecios(BigDecimal bdPrecio, Usuario usuario, Asiento asiento)
	{
		double precio;
		double precioTotal;

		precio = bdPrecio.doubleValue();
		precioTotal = this.getPrecioTotal(precio, usuario);

		asiento.setPrecio(precio);
		asiento.setPrecioTotal(precioTotal);
	}

	private void establecerFechasYHorarios(AsientoDTO dto, Asiento asiento)
	{
		Date fSalida = null;
		Date hSalida = null;
		Date fLlegada = null;
		Date hLlegada = null;

		if(dto.getFechaDeSalida() != null) fSalida = UFecha.convertirAFecha(dto.getFechaDeSalida());
		if(dto.getHoraDeSalida() != null) hSalida = UFecha.convertirAHora(dto.getHoraDeSalida());
		if(dto.getFechaDeLlegada() != null) fLlegada = UFecha.convertirAFecha(dto.getFechaDeLlegada());
		if(dto.getHoraDeLlegada() != null) hLlegada = UFecha.convertirAHora(dto.getHoraDeLlegada());

		asiento.setFechaSalida(fSalida);
		asiento.setHoraSalida(hSalida);
		asiento.setFechaLlegada(fLlegada);
		asiento.setHoraLlegada(hLlegada);
	}

	private void establecerClase(String clase, Asiento asiento)
	{
		switch(clase.charAt(0))
		{
			case 'P':
				asiento.setClase(new PrimeraClase());
				break;
			case 'E':
				asiento.setClase(new ClaseEjecutiva());
				break;
			default:
				asiento.setClase(new ClaseTurista());
				break;
		}
	}

	private void establecerUbicacion(String ubicacion, Asiento asiento)
	{
		switch(ubicacion.charAt(0))
		{
			case 'P':
				asiento.setUbicacion(new UbicacionPasillo());
				break;
			case 'C':
				asiento.setUbicacion(new UbicacionCentro());
				break;
			default:
				asiento.setUbicacion(new UbicacionVentana());
				break;
		}

	}

	private void establecerEstado(boolean reservado, Asiento asiento)
	{
		if(reservado)
		{
			asiento.setEstado(new EstadoReservado());
		}
		else
		{
			asiento.setEstado(new EstadoDisponible());
		}
	}

	private void establecerVuelo(String codigo)
	{
		VuelosBD.agregarVuelo(codigo);
	}

	@Override
	public void comprarAsiento(Asiento asiento, Usuario usuario)
	{
		boolean operacionExitosa;
		String codigoVuelo = asiento.getCodigoVuelo();
		int numeroAsiento = asiento.getNumeroAsiento();

		String dni = String.valueOf(usuario.getDni());
		operacionExitosa = this.getInstancia().comprarSiHayDisponibilidad(dni, codigoVuelo, numeroAsiento);

		if(!operacionExitosa) throw new AsientoNoDisponibleException(codigoVuelo, numeroAsiento);
	}

	@Override
	public void reservarAsiento(Asiento asiento, Usuario usuario)
	{
		boolean operacionExitosa;
		String codigoVuelo = asiento.getCodigoVuelo();
		int numeroAsiento = asiento.getNumeroAsiento();

		String dni = String.valueOf(usuario.getDni());
		operacionExitosa = this.getInstancia().reservar(dni, codigoVuelo, numeroAsiento);

		if(!operacionExitosa) throw new AsientoNoDisponibleException(codigoVuelo, numeroAsiento);
	}

	@Override
	public String toString()
	{
		return this.getNombre();
	}

	
	
}
