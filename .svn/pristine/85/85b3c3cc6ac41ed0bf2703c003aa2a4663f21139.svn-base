package domain.dao.imple;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import util.UFactory;
import util.UFiltro;
import domain.Aerolinea;
import domain.Asiento;
import domain.Busqueda;
import domain.Clase;
import domain.Usuario;
import domain.dao.AerolineaDAO;

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
		Aerolinea aerolinea = asiento.getAerolinea();
		aerolinea.comprarAsiento(asiento, usuario);
	}

	@Override
	public Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario)
	{
		Collection<Asiento> col = new Vector<Asiento>();
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();

		for(Aerolinea aerolinea : aerolineas)
		{
			nuevaColeccion = aerolinea.obtenerAsientosDisponibles(busqueda, usuario);
			col.addAll(nuevaColeccion);
		}

		col = UFiltro.filtrarAsientos((List<Clase>) busqueda.getClase(), busqueda.getUbicacion(), busqueda.getPrecioMin(), busqueda.getPrecioMax(), 
				busqueda.isIncluirReservados(), col, usuario);

		return col;
	}

	@Override
	public void reservarAsiento(Asiento asiento, Usuario usuario)
	{
		Aerolinea aerolinea = asiento.getAerolinea();
		aerolinea.reservarAsiento(asiento, usuario);
	}

	
	//Getters & Setters
	
	public Collection<Aerolinea> getAerolineas()
	{
		return aerolineas;
	}

	public void setAerolineas(Collection<Aerolinea> aerolineas)
	{
		this.aerolineas = aerolineas;
	}
}
