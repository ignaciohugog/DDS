package app.model;

import java.util.Collection;
import java.util.Vector;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import util.UFactory;
import util.UFecha;
import util.fecha.Fecha;
import app.Aterrizar;
import criterioDeOrdenamiento.imple.SinCriterio;
import domain.Asiento;
import domain.Busqueda;
import domain.Ciudad;
import domain.Usuario;
import domain.exception.AsientoSinSeleccionarException;
import domain.exception.FormatoDeFechaIncorrectoException;

@Observable
public class AterrizarAppModel
{
	/*
	 * CONSTRUCTOR
	 */


	public AterrizarAppModel()
	{
		domainModel = (Aterrizar) UFactory.getInstancia("ATERRIZAR");
		domainModel.altaUsuario("Roberto", "Gonzalez", 25447898);
		usuario = domainModel.autenticar("Roberto", "Gonzalez", 25447898);
		asientosComprados = new Vector<Asiento>();
		asientosReservados = new Vector<Asiento>();
		resultadoBusqueda = new Vector<Asiento>();
		asientosComprados = usuario.getAsientosComprados();
		asientosReservados = usuario.getAsientosReservados();
		asientoSeleccionado = null;
	}

	private Aterrizar domainModel;
	private Usuario usuario;
	private Asiento asientoSeleccionado;
	private String origen;
	private String destino;
	private String fechaSalida;
	private Collection<Asiento> asientosComprados;
	private Collection<Asiento> asientosReservados;
	private Collection<Asiento> resultadoBusqueda;
	private String nombre;
	private String apellido;
	private String dni;
	
	public void obtenerAsientosComprados()
	{
		asientosComprados = usuario.getAsientosComprados();
	}

	public void obtenerAsientosReservados()
	{
		asientosReservados = usuario.getAsientosReservados();
	}

	public void buscar()
	{
		Collection<Asiento> resultado = new Vector<Asiento>();

		Ciudad ciudadOrigen = new Ciudad(this.getOrigen());
		Ciudad ciudadDestino = new Ciudad(this.getDestino());
		Fecha unaFechaSalida = UFecha.convertirAFecha(this.getFechaSalida());

		Busqueda busqueda = new Busqueda(ciudadOrigen, ciudadDestino, unaFechaSalida, null, null, null, null, null, null, null, new SinCriterio(), null, null);

		resultado = domainModel.obtenerAsientosDisponibles(busqueda, this.getUsuario());

		this.setResultadoBusqueda(resultado);
	}

	public void comprar()
	{
		domainModel.comprarAsiento(this.getAsientoSeleccionado(), this.getUsuario());
		this.buscar();
		asientoSeleccionado = null;
	}

	public void reservar()
	{	
		domainModel.reservarAsiento(this.getAsientoSeleccionado(), this.getUsuario());
		this.buscar();
		asientoSeleccionado = null;
	}

	private void validarFormato(String fechaSalida)
	{
		try
		{
			UFecha.convertirAFecha(fechaSalida);
		}
		catch(FormatoDeFechaIncorrectoException ex)
		{
			throw new UserException(ex.getMessage());
		}
	}

	public void limpiar()
	{
		this.origen = null;
		this.destino = null;
		this.fechaSalida = null;
		this.resultadoBusqueda = null;
	}
	
	
	
	/*
	 * GETTERS & SETTERS
	 */

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public Aterrizar getDomainModel()
	{
		return domainModel;
	}

	public void setDomainModel(Aterrizar domainModel)
	{
		this.domainModel = domainModel;
	}

	public Asiento getAsientoSeleccionado()
	{
		return asientoSeleccionado;
	}

	public void setAsientoSeleccionado(Asiento asientoSeleccionado)
	{
		this.asientoSeleccionado = asientoSeleccionado;
	}

	public String getOrigen()
	{
		return origen;
	}

	public void setOrigen(String origen)
	{
		this.origen = origen;			

		if(this.origen.equals(""))
		{
			this.origen = null;
		}
	}

	public String getDestino()
	{
		return destino;
	}

	public void setDestino(String destino)
	{
		this.destino = destino;
		
		if(this.destino.equals(""))
		{
			this.destino = null;
		}
	}

	public String getFechaSalida()
	{
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida)
	{
		this.fechaSalida = fechaSalida;		
		
		if(this.fechaSalida.equals("") || this.fechaSalida == null)
		{
			this.fechaSalida = null;
		}
		else 
		{
			this.validarFormato(this.fechaSalida);			
		}
	}

	public Collection<Asiento> getResultadoBusqueda()
	{
		return resultadoBusqueda;
	}

	public void setResultadoBusqueda(Collection<Asiento> resultadoBusqueda)
	{
		this.resultadoBusqueda = resultadoBusqueda;
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

	public String getDni()
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}

}
