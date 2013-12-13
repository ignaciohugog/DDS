package app.imple;

import java.util.Collection;

import baseDeDatos.VuelosBD;

import util.UFactory;
import app.Aterrizar;
import domain.Asiento;
import domain.Busqueda;
import domain.Usuario;
import domain.dao.AerolineaDAO;
import domain.dao.UsuarioDAO;

public class AterrizarImple implements Aterrizar
{
	
	@Override
	public Usuario autenticar(String nombre, String apellido, int dni)
	{
		UsuarioDAO usuarioDAO = (UsuarioDAO)UFactory.getInstancia("USUARIO_DAO");
		Usuario user = usuarioDAO.buscarUsuario(nombre, apellido, dni);
		
		return user;
	}
	

	@Override
	public Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario)
	{
		AerolineaDAO aerolineaDAO = (AerolineaDAO) UFactory.getInstancia("AEROLINEA_DAO");
		Collection<Asiento> col = aerolineaDAO.obtenerAsientosDisponibles(busqueda, usuario);
		
		usuario.agregarBusqueda(busqueda, col);
		
		return col;
	}
	

	@Override
	public void comprarAsiento(Asiento asiento, Usuario usuario)
	{
		AerolineaDAO aerolineaDAO = (AerolineaDAO) UFactory.getInstancia("AEROLINEA_DAO");
		aerolineaDAO.comprarAsiento(asiento, usuario);
		VuelosBD.incrementarPopularidad(asiento.getCodigoVuelo());
	}


	@Override
	public void reservarAsiento(Asiento asiento, Usuario usuario)
	{
		AerolineaDAO aerolineaDAO = (AerolineaDAO) UFactory.getInstancia("AEROLINEA_DAO");
		aerolineaDAO.reservarAsiento(asiento, usuario);
	}	
	
	
}
