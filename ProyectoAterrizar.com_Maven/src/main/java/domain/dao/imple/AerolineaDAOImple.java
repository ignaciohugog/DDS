package domain.dao.imple;

import java.util.Collection;
import java.util.Vector;

import util.UFactory;
import util.UFiltro;
import domain.Aerolinea;
import domain.Asiento;
import domain.Busqueda;
import domain.Usuario;
import domain.dao.AerolineaDAO;
import domain.exception.AsientoSinSeleccionarException;
import domain.exception.FaltanCompletarCamposObligatoriosException;

public class AerolineaDAOImple implements AerolineaDAO
{
	public Collection<Aerolinea> aerolineas = new Vector<Aerolinea>();

	public AerolineaDAOImple()
	{
		aerolineas = UFactory.getAerolineas();
	}

	@Override
	public void comprarAsiento(Asiento asiento, Usuario usuario)
	{
		this.validarOperacion(asiento);
		Aerolinea aerolinea = asiento.getAerolinea();
		aerolinea.comprarAsiento(asiento, usuario);
	}

	@Override
	public Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario)
	{
		Collection<Asiento> col = new Vector<Asiento>();
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();

		this.verificarParametros(busqueda);

		for(Aerolinea aerolinea : aerolineas)
		{
			nuevaColeccion = aerolinea.obtenerAsientosDisponibles(busqueda, usuario);
			col.addAll(nuevaColeccion);
		}

		col = UFiltro.filtrarAsientos(busqueda, col, usuario);
		busqueda.getCriterio().aplicarCriterio(col);

		return col;
	}

	@Override
	public void reservarAsiento(Asiento asiento, Usuario usuario)
	{
		this.validarOperacion(asiento);
		Aerolinea aerolinea = asiento.getAerolinea();
		aerolinea.reservarAsiento(asiento, usuario);
	}

	private void verificarParametros(Busqueda busqueda)
	{
		if(busqueda.getOrigen().toString() == null || busqueda.getDestino().toString() == null || busqueda.getFechaSalida() == null)
		{
			throw new FaltanCompletarCamposObligatoriosException();
		}
	}

	// Getters & Setters

	public Collection<Aerolinea> getAerolineas()
	{
		return aerolineas;
	}

	public void setAerolineas(Collection<Aerolinea> aerolineas)
	{
		this.aerolineas = aerolineas;
	}
	
	private void validarOperacion(Asiento asiento)
	{
		if(asiento == null)
		{
			throw new AsientoSinSeleccionarException();
		}
	}

}
