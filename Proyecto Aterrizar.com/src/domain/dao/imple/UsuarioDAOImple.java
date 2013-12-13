package domain.dao.imple;

import domain.Usuario;
import domain.dao.UsuarioDAO;
import domain.usuarios.UsuarioVIP;

public class UsuarioDAOImple implements UsuarioDAO
{

	@Override
	public Usuario buscarUsuario(String nombre, String apellido, int dni)
	{
		//Por el momento devolverá siempre el usuario buscado
		Usuario user = new UsuarioVIP();
		user.setNombre(nombre);
		user.setApellido(apellido);
		user.setDni(dni);
		
		return user;
	}

	
}
