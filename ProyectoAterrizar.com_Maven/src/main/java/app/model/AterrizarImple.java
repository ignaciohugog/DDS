package app.model;

import java.util.Collection;

import baseDeDatos.VuelosBD;

import util.UFactory;
import app.Aterrizar;
import domain.Asiento;
import domain.Busqueda;
import domain.Usuario;
import domain.dao.AerolineaDAO;
import domain.dao.UsuarioDAO;
import domain.exception.UsuarioNoDefinidoException;

public class AterrizarImple implements Aterrizar
{

	@Override
	public Usuario autenticar(String nombre, String apellido, int dni)
	{
		UsuarioDAO usuarioDAO = (UsuarioDAO) UFactory.getInstancia("USUARIO_DAO");
		Usuario user = usuarioDAO.buscarUsuario(nombre, apellido, dni);

		return user;
	}

	@Override
	public Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario)
	{
		this.validarOperacion(usuario);
		AerolineaDAO aerolineaDAO = (AerolineaDAO) UFactory.getInstancia("AEROLINEA_DAO");
		Collection<Asiento> col = aerolineaDAO.obtenerAsientosDisponibles(busqueda, usuario);

		usuario.agregarBusqueda(busqueda, col);

		return col;
	}

	@Override
	public void comprarAsiento(Asiento asiento, Usuario usuario)
	{
		this.validarOperacion(usuario);
		AerolineaDAO aerolineaDAO = (AerolineaDAO) UFactory.getInstancia("AEROLINEA_DAO");
		aerolineaDAO.comprarAsiento(asiento, usuario);
		VuelosBD.incrementarPopularidad(asiento.getCodigoVuelo());
		usuario.agregarAsientoComprado(asiento);
	}

	@Override
	public void reservarAsiento(Asiento asiento, Usuario usuario)
	{
		this.validarOperacion(usuario);
		AerolineaDAO aerolineaDAO = (AerolineaDAO) UFactory.getInstancia("AEROLINEA_DAO");
		aerolineaDAO.reservarAsiento(asiento, usuario);
		usuario.agregarAsientoReservado(asiento);
	}

	@Override
	public void altaUsuario(String nombre, String apellido, int dni)
	{
		UsuarioDAO usuarioDAO = (UsuarioDAO) UFactory.getInstancia("USUARIO_DAO");
		usuarioDAO.altaUsuario(nombre, apellido, dni);
	}
	
	private void validarOperacion(Usuario usuario)
	{
		if(usuario == null)
		{
			throw new UsuarioNoDefinidoException();
		}
	}

}
