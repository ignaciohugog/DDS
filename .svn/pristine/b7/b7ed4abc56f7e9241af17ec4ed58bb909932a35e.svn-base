package domain.dao.imple;

import java.util.Collection;
import java.util.Vector;

import domain.Usuario;
import domain.dao.UsuarioDAO;
import domain.exception.UsuarioNoEncontradoException;
import domain.usuarios.UsuarioEstandar;

public class UsuarioDAOImple implements UsuarioDAO
{
	private Collection<Usuario> usuarios = new Vector<Usuario>();

	@Override
	public Usuario buscarUsuario(String nombre, String apellido, int dni)
	{
		Usuario resultado = null;
		Usuario usuarioBuscado = new UsuarioEstandar(nombre, apellido, dni);
		
		for(Usuario unUsuario : this.getUsuarios())
		{
			if(unUsuario.igualA(usuarioBuscado))
			{
				resultado = unUsuario;
			}
		}
		
		if(resultado == null) throw new UsuarioNoEncontradoException();
		
		return resultado;
	}

	@Override
	public void altaUsuario(String nombre, String apellido, int dni)
	{
		Usuario unUsuario = new UsuarioEstandar(nombre, apellido, dni);
		
		this.getUsuarios().add(unUsuario);
	}
	
	
	// Getters & Setters

	public Collection<Usuario> getUsuarios()
	{
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios)
	{
		this.usuarios = usuarios;
	}


}
