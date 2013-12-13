package domain.dao;

import domain.Usuario;

public interface UsuarioDAO
{
	public Usuario buscarUsuario(String nombre, String apellido, int dni);

	public void altaUsuario(String nombre, String apellido, int dni);
}
